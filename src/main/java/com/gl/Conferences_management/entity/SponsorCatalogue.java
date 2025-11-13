package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sponsor_catalogue")
@Data
public class SponsorCatalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prof;

    private String name;

    private String email;

    @Column(name = "alternate_email")
    private String alternateEmail;

    private String phone;

    private String organization;

    private String country;

    private String message;

    private Integer user;

}
