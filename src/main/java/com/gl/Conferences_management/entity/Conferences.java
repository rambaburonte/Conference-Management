package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "conferences")
@Data
public class Conferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String theme;

    @Column(name = "conference_date")
    private String conferenceDate;

    private String website;

    private String website1;

    @Column(name = "abstract")
    private String abstractField;

    private String abstract1;

    private String email;

    private String email1;

    private String email2;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "ceremony_time")
    private String ceremonyTime;

    @Column(name = "ceremony_place")
    private String ceremonyPlace;

    private String venue;

}
