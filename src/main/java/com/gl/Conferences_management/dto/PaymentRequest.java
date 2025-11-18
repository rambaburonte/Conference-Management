package com.gl.Conferences_management.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private String title;
    private String name;
    private String email;
    private String phone;
    private String country;
    private String address;
    private String org;
    private String paymentProvider;
    private double amount;
    private String currency = "USD";
   
    private String conf;
    private String category;
    private String description;
    private String successUrl;
    private String cancelUrl;
    private String user;
}
