package com.gl.Conferences_management.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gl.Conferences_management.dto.AbstractSubmissionResponse;
import com.gl.Conferences_management.service.MailService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/abstract")
@Slf4j
public class Abstract {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private MailService mailService;

    @Value("${ftp.host}")
    private String ftpHost;

    @Value("${ftp.port:21}")
    private int ftpPort;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp.password}")
    private String ftpPassword;

    @Value("${ftp.upload.path:/cms/pdfs}")
    private String ftpUploadPath;
      @Value("${ftp.connection-timeout:30000}")
    private int ftpConnectionTimeout;

    @Value("${ftp.data-timeout:30000}")
    private int ftpDataTimeout;

    @Value("${ftp.passive-mode:true}")
    private boolean ftpPassiveMode;

    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AbstractSubmissionResponse> submitAbstract(
            @RequestParam("file") MultipartFile file,
            @RequestParam("user") String user,
            @RequestParam("title") String title,
            @RequestParam("fname") String fname,
            @RequestParam("country") String country,
            @RequestParam(value = "org", required = false) String org,
            @RequestParam("email") String email,
            @RequestParam("phno") String phno,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "sentFrom", required = false) String sentFrom,
            @RequestParam(value = "trackName", required = false) String trackName,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "presentationTitle", required = false) String presentationTitle,
            @RequestParam(value = "entity", required = false) String entity,
            HttpServletRequest httpRequest
    ) {
        log.info("Received abstract submission request from user: {}, title: {}", user, title);
        FTPClient ftpClient = new FTPClient();
        try {
            String ipAddress = httpRequest.getRemoteAddr();
            log.debug("Client IP address: {}", ipAddress);

            // Insert into database without attachment to get ID
            String insertSql = "INSERT INTO abstract_submission (user, title, fname, country, org, email, phno, category, sent_from, track_name, address, date, ipaddress, presentation_title, entity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user);
                ps.setString(2, title);
                ps.setString(3, fname);
                ps.setString(4, country);
                ps.setString(5, org);
                ps.setString(6, email);
                ps.setString(7, phno);
                ps.setString(8, category);
                ps.setString(9, sentFrom);
                ps.setString(10, trackName);
                ps.setString(11, address);
                ps.setDate(12, Date.valueOf(LocalDate.now()));
                ps.setString(13, ipAddress);
                ps.setString(14, presentationTitle);
                ps.setString(15, entity);
                return ps;
            }, keyHolder);

            Long id = keyHolder.getKey().longValue();
            log.info("Abstract inserted into database with ID: {}", id);

            // Validate file before FTP upload
            if (file.isEmpty()) {
                log.error("Uploaded file is empty for ID: {}", id);
                return ResponseEntity.status(400).body(new AbstractSubmissionResponse(null, "Uploaded file is empty", "error", null));
            }

            if (file.getSize() > 10 * 1024 * 1024) { // 10MB limit
                log.error("File too large for ID: {}. Size: {} bytes", id, file.getSize());
                return ResponseEntity.status(400).body(new AbstractSubmissionResponse(null, "File size exceeds 10MB limit", "error", null));
            }

            // Generate unique file name with ID
            String originalFileName = file.getOriginalFilename();
            String uniqueFileName = id + "_" + originalFileName;
            log.info("File validation passed - Name: {}, Size: {} bytes, Unique name: {}", originalFileName, file.getSize(), uniqueFileName);

            // FTP upload with improved error handling
            log.info("Connecting to FTP server: {}:{}", ftpHost, ftpPort);
            ftpClient.setConnectTimeout(ftpConnectionTimeout);
            ftpClient.setDefaultTimeout(ftpDataTimeout);
            ftpClient.connect(ftpHost, ftpPort);
            log.info("FTP connection established, reply code: {}", ftpClient.getReplyCode());

            boolean loginSuccess = ftpClient.login(ftpUsername, ftpPassword);
            if (!loginSuccess) {
                log.error("FTP login failed for user: {}. Reply code: {}", ftpUsername, ftpClient.getReplyCode());
                throw new IOException("FTP login failed - check credentials");
            }
            log.info("FTP login successful");

            if (ftpPassiveMode) {
                ftpClient.enterLocalPassiveMode();
            }
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setBufferSize(1024 * 1024); // 1MB buffer

            log.info("Changing to FTP directory: {}", ftpUploadPath);
            boolean dirChanged = ftpClient.changeWorkingDirectory(ftpUploadPath);
            if (!dirChanged) {
                log.warn("Failed to change to directory: {}. Attempting to create it...", ftpUploadPath);
                // Try to create the directory
                boolean dirCreated = ftpClient.makeDirectory(ftpUploadPath);
                if (dirCreated) {
                    log.info("Created FTP directory: {}", ftpUploadPath);
                    dirChanged = ftpClient.changeWorkingDirectory(ftpUploadPath);
                }
                if (!dirChanged) {
                    log.error("Failed to access FTP directory: {}. Current directory: {}", ftpUploadPath, ftpClient.printWorkingDirectory());
                    throw new IOException("Failed to access FTP upload directory");
                }
            }
            log.info("FTP directory changed successfully");

            try (InputStream inputStream = file.getInputStream()) {
                log.info("Starting FTP upload for file: {} (size: {} bytes)", uniqueFileName, file.getSize());
                boolean done = ftpClient.storeFile(uniqueFileName, inputStream);

                if (done) {
                    log.info("File uploaded successfully to FTP: {}", uniqueFileName);
                    // Update attachment in database
                    jdbcTemplate.update("UPDATE abstract_submission SET attachment = ? WHERE id = ?", uniqueFileName, id);
                    log.info("Attachment updated in database for ID: {}", id);
                    
                    // Send email
                    try {
                        String userEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, user);
                        if (userEmail != null) {
                            String subject = "New Abstract Submission";
                            String abstractFileUrl = "https://ccai2026.com/cms/pdfs/" + uniqueFileName;
                            String body = String.format(
                                "Someone has submitted an abstract.\n\n" +
                                "Submission Details:\n" +
                                "ID: %d\n" +
                                "Title: %s\n" +
                                "Name: %s\n" +
                                "Email: %s\n" +
                                "Country: %s\n" +
                                "Organization: %s\n" +
                                "Phone: %s\n" +
                                "Category: %s\n" +
                                "Track: %s\n" +
                                "Address: %s\n" +
                                "Paper Title: %s\n" +
                                "Date: %s\n" +
                                "IP Address: %s\n\n" +
                                "Abstract File: %s\n\n" +
                                "Please review the submission.",
                                id, title, fname, email,
                                country, org, phno,
                                category, trackName, address,
                                presentationTitle, LocalDate.now(), ipAddress, abstractFileUrl
                            );
                            mailService.sendEmail(userEmail, subject, body);
                            log.info("Abstract submission confirmation email sent to: {}", userEmail);
                        } else {
                            log.warn("No email found in login_details for user: {}", user);
                        }
                    } catch (Exception e) {
                        log.error("Error sending abstract submission email for user: {}", user, e);
                    }
                    
                    log.info("Abstract submission successful for ID: {}", id);
                    return ResponseEntity.ok(new AbstractSubmissionResponse(id, "Abstract submitted successfully", "success", uniqueFileName));
                } else {
                    int replyCode = ftpClient.getReplyCode();
                    String replyString = ftpClient.getReplyString();
                    log.error("FTP file upload failed for ID: {}. Reply code: {}, Reply: {}", id, replyCode, replyString);
                    log.error("FTP upload details - File: {}, Size: {}, Current dir: {}", uniqueFileName, file.getSize(), ftpClient.printWorkingDirectory());
                    return ResponseEntity.status(500).body(new AbstractSubmissionResponse(null, "File upload failed - FTP error", "error", null));
                }
            }
        } catch (Exception e) {
            log.error("Error submitting abstract for user: {}. Error type: {}, Message: {}", user, e.getClass().getSimpleName(), e.getMessage(), e);

            // Provide more specific error messages
            String errorMessage = "Error: " + e.getMessage();
            if (e.getMessage().contains("FTP") || e.getMessage().contains("ftp")) {
                errorMessage = "File upload failed: " + e.getMessage();
            } else if (e.getMessage().contains("database") || e.getMessage().contains("SQL")) {
                errorMessage = "Database error occurred";
            }

            return ResponseEntity.status(500).body(new AbstractSubmissionResponse(null, errorMessage, "error", null));
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    log.debug("FTP connection closed");
                }
            } catch (IOException ex) {
                log.error("Error closing FTP connection", ex);
            }
        }
    }
}
