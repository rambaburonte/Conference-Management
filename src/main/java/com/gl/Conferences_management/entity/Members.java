package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "members")
@Data
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String affiliation;

    private String email;

    private String photo;

    @Column(name = "speaker_category")
    private String speakerCategory;

    private String biography;

    private String research;

    @Column(name = "abstract")
    private String abstractContent;

    private String category;

    private Integer user;

    @Column(name = "recordListingID")
    private Integer recordListingId;

}
