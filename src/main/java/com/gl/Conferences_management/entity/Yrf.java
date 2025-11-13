package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "yrf")
@Data
public class Yrf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String affiliation;

    private String photo;

    private String biography;

    private String research;

    @Column(name = "abstract")
    private String abstractContent;

    private Integer user;

    @Column(name = "recordListingID")
    private Integer recordListingId;

}
