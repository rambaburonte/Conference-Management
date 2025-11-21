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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gl.Conferences_management.dto.AbstractSubmissionRequest;
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

    @PostMapping("/submit")
    public ResponseEntity<AbstractSubmissionResponse> submitAbstract(
            @RequestParam("file") MultipartFile file,
            @ModelAttribute AbstractSubmissionRequest request,
            HttpServletRequest httpRequest
    ) {
        log.info("Received abstract submission request from user: {}, title: {}", request.getUser(), request.getTitle());
        FTPClient ftpClient = new FTPClient();
        try {
            String ipAddress = httpRequest.getRemoteAddr();
            log.debug("Client IP address: {}", ipAddress);

            // Insert into database without attachment to get ID
            String insertSql = "INSERT INTO abstract_submission (user, title, fname, country, org, email, phno, category, sent_from, track_name, address, date, ipaddress, presentation_title, entity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, request.getUser());
                ps.setString(2, request.getTitle());
                ps.setString(3, request.getFname());
                ps.setString(4, request.getCountry());
                ps.setString(5, request.getOrg());
                ps.setString(6, request.getEmail());
                ps.setString(7, request.getPhno());
                ps.setString(8, request.getCategory());
                ps.setString(9, request.getSentFrom());
                ps.setString(10, request.getTrackName());
                ps.setString(11, request.getAddress());
                ps.setDate(12, Date.valueOf(LocalDate.now()));
                ps.setString(13, ipAddress);
                ps.setString(14, request.getPresentationTitle());
                ps.setString(15, request.getEntity());
                return ps;
            }, keyHolder);

            Long id = keyHolder.getKey().longValue();
            log.info("Abstract inserted into database with ID: {}", id);

            // Generate unique file name with ID
            String originalFileName = file.getOriginalFilename();
            String uniqueFileName = id + "_" + originalFileName;
            log.debug("Generated unique filename: {}", uniqueFileName);

            // FTP upload
            log.info("Connecting to FTP server: {}", ftpHost);
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory(ftpUploadPath);

            try (InputStream inputStream = file.getInputStream()) {
                boolean done = ftpClient.storeFile(uniqueFileName, inputStream);
                if (done) {
                    log.info("File uploaded successfully to FTP: {}", uniqueFileName);
                    // Update attachment in database
                    jdbcTemplate.update("UPDATE abstract_submission SET attachment = ? WHERE id = ?", uniqueFileName, id);
                    log.info("Attachment updated in database for ID: {}", id);
                    
                    // Send email
                    try {
                        String userEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, request.getUser());
                        if (userEmail != null) {
                            String subject = "New Abstract Submission";
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
                                "Please review the submission.",
                                id, request.getTitle(), request.getFname(), request.getEmail(),
                                request.getCountry(), request.getOrg(), request.getPhno(),
                                request.getCategory(), request.getTrackName(), request.getAddress(),
                                request.getPresentationTitle(), LocalDate.now(), ipAddress
                            );
                            mailService.sendEmail(userEmail, subject, body);
                            log.info("Abstract submission confirmation email sent to: {}", userEmail);
                        } else {
                            log.warn("No email found in login_details for user: {}", request.getUser());
                        }
                    } catch (Exception e) {
                        log.error("Error sending abstract submission email for user: {}", request.getUser(), e);
                    }
                    
                    log.info("Abstract submission successful for ID: {}", id);
                    return ResponseEntity.ok(new AbstractSubmissionResponse(id, "Abstract submitted successfully", "success", uniqueFileName));
                } else {
                    log.error("FTP file upload failed for ID: {}", id);
                    return ResponseEntity.status(500).body(new AbstractSubmissionResponse(null, "File upload failed", "error", null));
                }
            }
        } catch (Exception e) {
            log.error("Error submitting abstract for user: {}", request.getUser(), e);
            return ResponseEntity.status(500).body(new AbstractSubmissionResponse(null, "Error: " + e.getMessage(), "error", null));
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
