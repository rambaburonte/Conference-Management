package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "callforabstracts")
@Data
public class Callforabstracts {

    @Column(name = "recordListingID")
    private Integer recordListingId;

    @Column(name = "TrackName")
    private String trackName;

    private String category;

    private Integer user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SubTof")
    private String subTof;

    @Column(name = "TrackIdentity")
    private String trackIdentity;

    private String description;

}
