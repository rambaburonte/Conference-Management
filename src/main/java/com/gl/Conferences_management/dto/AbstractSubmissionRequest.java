package com.gl.Conferences_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AbstractSubmissionRequest {

    @NotBlank(message = "User is mandatory")
    private String user;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "First Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z\\.\\-_ ]{1,50}$", message = "First Name with only a-z A-Z.")
    private String fname;

    @NotBlank(message = "Country is mandatory")
    @Pattern(regexp = "^[a-zA-Z_.()&+'\\-:\\.\\ ]{1,50}$", message = "Enter Your Country")
    private String country;

    private String org; // Optional

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Enter Valid Email")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", message = "Enter Valid Email with only a-z 0-9")
    private String email;

    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "^[0-9]{9,15}$", message = "Phone Number must be 9-15 digits")
    private String phno;

    private String category; // Optional

    private String sentFrom; // Optional

    private String trackName; // Optional

    private String address; // Optional

    private String presentationTitle; // Optional

    private String entity; // Optional
}