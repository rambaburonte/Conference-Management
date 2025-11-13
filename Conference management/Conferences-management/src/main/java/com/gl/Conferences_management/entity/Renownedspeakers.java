package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "renownedspeakers")
@Data
public class Renownedspeakers {

    private Integer user;

    private String name1;

    private String photo1;

    private String affiliation1;

    private String country1;

    private String name2;

    private String photo2;

    private String affiliation2;

    private String country2;

    private String tdate;

    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String biography1;

    private String biography2;

    @Column(name = "recordListingID")
    private Integer recordListingId;

}
