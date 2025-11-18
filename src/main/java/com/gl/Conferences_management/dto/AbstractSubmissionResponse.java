package com.gl.Conferences_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractSubmissionResponse {
    private Long id;
    private String message;
    private String status; // success, error
    private String attachmentUrl;
}