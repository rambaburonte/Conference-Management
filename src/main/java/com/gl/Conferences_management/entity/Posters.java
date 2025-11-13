package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "posters")
@Data
public class Posters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user;

    private String name;

    private String affiliation;

    private String pdf;

    private String photo;

    private String logo;

    @Column(name = "recordListingID")
    private Integer recordListingId;

    private String biography;

    @Column(name = "abstract")
    private String abstractContent;

}
