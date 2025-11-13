package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "keynotes")
@Data
public class Keynotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String day;

    private Integer keynote;

    @Column(name = "speaker_name")
    private String speakerName;

    @Column(name = "speaker_photo")
    private String speakerPhoto;

    @Column(name = "speaker_logo")
    private String speakerLogo;

    @Column(name = "speaker_affiliation")
    private String speakerAffiliation;

    @Column(name = "key_pdf")
    private String keyPdf;

    @Column(name = "break")
    private String breakField;

    private String time;

    private Integer user;

    private Integer sid;

    @Column(name = "recordListingID")
    private Integer recordListingId;

    private String tittle;

    private String biography;

    @Column(name = "abstract")
    private String abstractContent;

}
