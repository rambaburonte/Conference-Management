package com.gl.Conferences_management.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private String name;
    private String email;
    private String subject;
    private String message;
    private String user;

    
}