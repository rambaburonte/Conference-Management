package com.gl.Conferences_management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Suggest_Speaker")
@Data
public class SuggestSpeaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String mailId;

    private String speakerName;

    private String speakerMailId;

    private String message;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
