package com.gl.Conferences_management.controller;

import com.gl.Conferences_management.dto.RegistrationRequest;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.sql.Date;
import java.time.LocalDate;

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
            // Generate unique file name
            String originalFileName = file.getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;

            // FTP upload
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory(ftpUploadPath);

            InputStream inputStream = file.getInputStream();
            boolean done = ftpClient.storeFile(uniqueFileName, inputStream);
            inputStream.close();

            if (done) {
                // Insert into database
                String sql = "INSERT INTO abstract_submission (user, title, fname, country, org, email, phno, category, sent_from, track_name, address, date, ipaddress, attachment, presentation_title, entity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String ipAddress = InetAddress.getLocalHost().getHostAddress(); // Or get from request
                jdbcTemplate.update(sql, user, title, fname, country, org, email, phno, category, sentFrom, trackName, address, Date.valueOf(LocalDate.now()), ipAddress, uniqueFileName, presentationTitle, entity);

                return ResponseEntity.ok("Abstract submitted successfully");
            } else {
                return ResponseEntity.status(500).body("File upload failed");
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
                ex.printStackTrace();
            }
        }
    }
}
