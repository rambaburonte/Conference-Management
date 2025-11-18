package com.gl.Conferences_management.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
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


@RestController
@RequestMapping("/api/abstract")
public class Abstract {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${ftp.host}")
    private String ftpHost;

    @Value("${ftp.port:21}")
    private int ftpPort;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp.password}")
    private String ftpPassword;

    @Value("${ftp.upload.path:/uploads}")
    private String ftpUploadPath;

    @PostMapping("/submit")
    public ResponseEntity<AbstractSubmissionResponse> submitAbstract(
            @RequestParam("file") MultipartFile file,
            @ModelAttribute AbstractSubmissionRequest request
    ) {
        FTPClient ftpClient = new FTPClient();
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();

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

            // Generate unique file name with ID
            String originalFileName = file.getOriginalFilename();
            String uniqueFileName = id + "_" + originalFileName;

            // FTP upload
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory(ftpUploadPath);

            try (InputStream inputStream = file.getInputStream()) {
                boolean done = ftpClient.storeFile(uniqueFileName, inputStream);
                if (done) {
                    // Update attachment in database
                    jdbcTemplate.update("UPDATE abstract_submission SET attachment = ? WHERE id = ?", uniqueFileName, id);
                    return ResponseEntity.ok(new AbstractSubmissionResponse(id, "Abstract submitted successfully", "success", uniqueFileName));
                } else {
                    return ResponseEntity.status(500).body(new AbstractSubmissionResponse(null, "File upload failed", "error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new AbstractSubmissionResponse(null, "Error: " + e.getMessage(), "error", null));
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                // Log or handle
            }
        }
    }
}
