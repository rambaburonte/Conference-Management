package com.gl.Conferences_management.controller;

import com.gl.Conferences_management.dto.RegistrationRequest;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


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
    public ResponseEntity<?> submitAbstract(
            @RequestParam("file") MultipartFile file,
            @RequestParam("user") String user,
            @RequestParam("title") String title,
            @RequestParam("fname") String fname,
            @RequestParam("country") String country,
            @RequestParam(value = "org", required = false) String org,
            @RequestParam("email") String email,
            @RequestParam("phno") String phno,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "sent_from", required = false) String sentFrom,
            @RequestParam(value = "track_name", required = false) String trackName,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "presentation_title", required = false) String presentationTitle,
            @RequestParam(value = "entity", required = false) String entity
    ) {
        FTPClient ftpClient = new FTPClient();
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();

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
                    return ResponseEntity.ok("Abstract submitted successfully");
                } else {
                    return ResponseEntity.status(500).body("File upload failed");
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
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
