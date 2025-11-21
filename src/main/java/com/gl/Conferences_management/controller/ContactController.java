package com.gl.Conferences_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Conferences_management.dto.ContactRequest;
import com.gl.Conferences_management.dto.SubscribeRequest;
import com.gl.Conferences_management.service.MailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ContactController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private MailService mailService;
    
    @PostMapping("/contact-us")
    public ResponseEntity<String> createContact(@RequestBody ContactRequest request) {
        log.info("Received contact request from user: {}", request.getUser());
        try {
            jdbcTemplate.update("INSERT INTO contact_us (name, email, subject, message, user) VALUES (?, ?, ?, ?, ?)",
                request.getName(), request.getEmail(), request.getSubject(), request.getMessage(), request.getUser());
            log.info("Contact inserted into database for user: {}", request.getUser());
            
            // Send email
            try {
                String userEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, request.getUser());
                if (userEmail != null) {
                    String emailBody = "Someone is contacting you with the following entered data:\n\n" +
                        "Name: " + request.getName() + "\n" +
                        "Email: " + request.getEmail() + "\n" +
                        "Subject: " + request.getSubject() + "\n" +
                        "Message: " + request.getMessage();
                    mailService.sendEmail(userEmail, "Someone contacting you", emailBody);
                    log.info("Contact confirmation email sent to: {}", userEmail);
                } else {
                    log.warn("No email found in login_details for user: {}", request.getUser());
                }
            } catch (Exception e) {
                log.error("Error sending contact email for user: {}", request.getUser(), e);
            }
            
            log.info("Contact creation successful for user: {}", request.getUser());
            return ResponseEntity.ok("Contact created successfully");
        } catch (Exception e) {
            log.error("Error creating contact for user: {}", request.getUser(), e);
            return ResponseEntity.status(500).body("Error creating contact: " + e.getMessage());
        }
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> createSubscribe(@RequestBody SubscribeRequest request) {
        log.info("Received subscribe request for email: {}, user: {}", request.getEmail(), request.getUser());
        try {
            jdbcTemplate.update("INSERT INTO subscribes (email, status, category) VALUES (?, 1, ?)",
                request.getEmail(), request.getCategory());
            log.info("Subscription inserted into database for email: {}", request.getEmail());
            
            // Send email
            try {
                String toEmail = request.getEmail(); // default to submitted email
                if (request.getUser() != null) {
                    String loginEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, request.getUser());
                    if (loginEmail != null) {
                        toEmail = loginEmail;
                        log.info("Using login email for subscription: {}", loginEmail);
                    } else {
                        log.warn("No login email found for user: {}, using submitted email: {}", request.getUser(), request.getEmail());
                    }
                }
                mailService.sendEmail(toEmail, "Subscription Confirmation", "Thank you for subscribing to our updates.");
                log.info("Subscription confirmation email sent to: {}", toEmail);
            } catch (Exception e) {
                log.error("Error sending subscription email for email: {}", request.getEmail(), e);
            }
            
            log.info("Subscription creation successful for email: {}", request.getEmail());
            return ResponseEntity.ok("Subscribed successfully");
        } catch (Exception e) {
            log.error("Error subscribing for email: {}", request.getEmail(), e);
            return ResponseEntity.status(500).body("Error subscribing: " + e.getMessage());
        }
    }
}
