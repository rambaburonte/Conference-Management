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
@Table(name = "abstract_submission")
@Data
public class AbstractSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String user;

    private String title;

    private String fname;

    private String country;

    private String org;

    private String email;

    private String phno;

    private String category;

    @Column(name = "sent_from")
    private String sentFrom;

    @Column(name = "track_name")
    private String trackName;

    private String address;

    private LocalDate date;

    private String ipaddress;

    private String attachment;

    @Column(name = "presentation_title")
    private String presentationTitle;

    private String entity;

}
