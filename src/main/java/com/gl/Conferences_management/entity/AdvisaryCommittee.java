package com.gl.Conferences_management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "advisary_committee")
@Data
public class AdvisaryCommittee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String affiliation;

    private String photo;

    private String biography;

    private String research;

    private String pub1;

    private String pub2;

    private String pub3;

    private String pub4;

    private String network;

    private LocalDate date;

    private Integer user;

    @Column(name = "recordListingID")
    private Integer recordListingId;

}
