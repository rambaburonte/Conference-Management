package com.gl.Conferences_management.dto;

import lombok.Data;

@Data
public class SubscribeRequest {
    private String email;
    private String category;
    private String user;

    
}