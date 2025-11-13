package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "track_speakers")
@Data
public class TrackSpeakers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer track;

    private String time;

    @Column(name = "speaker_title")
    private String speakerTitle;

    @Column(name = "speaker_name")
    private String speakerName;

    @Column(name = "speaker_photo")
    private String speakerPhoto;

    @Column(name = "speaker_logo")
    private String speakerLogo;

    @Column(name = "spk_pdf")
    private String spkPdf;

    @Column(name = "speaker_affiliation")
    private String speakerAffiliation;

    @Column(name = "plenary_title")
    private String plenaryTitle;

    @Column(name = "time_1")
    private String time1;

    @Column(name = "plenary_name")
    private String plenaryName;

    @Column(name = "plenary_affiliation")
    private String plenaryAffiliation;

    @Column(name = "plenary_photo")
    private String plenaryPhoto;

    @Column(name = "plenary_logo")
    private String plenaryLogo;

    @Column(name = "plenary_pdf")
    private String plenaryPdf;

    @Column(name = "break")
    private String breakField;

    private Integer user;

    @Column(name = "recordListingID")
    private Integer recordListingId;

    private String biography;

    @Column(name = "abstract")
    private String abstractContent;

}
