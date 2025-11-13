package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "meta_tags")
@Data
public class MetaTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user;

    @Column(name = "main_title")
    private String mainTitle;

    private String description;

    private String keywords;

    @Column(name = "abs_title")
    private String absTitle;

    @Column(name = "abs_description")
    private String absDescription;

    @Column(name = "abs_keywords")
    private String absKeywords;

    @Column(name = "reg_title")
    private String regTitle;

    @Column(name = "reg_description")
    private String regDescription;

    @Column(name = "reg_keywords")
    private String regKeywords;

    @Column(name = "guidelines_title")
    private String guidelinesTitle;

    @Column(name = "guidelines_description")
    private String guidelinesDescription;

    @Column(name = "guidelines_keywords")
    private String guidelinesKeywords;

    @Column(name = "policies_title")
    private String policiesTitle;

    @Column(name = "policies_description")
    private String policiesDescription;

    @Column(name = "policies_keywords")
    private String policiesKeywords;

    @Column(name = "contact_title")
    private String contactTitle;

    @Column(name = "contact_description")
    private String contactDescription;

    @Column(name = "contact_keywords")
    private String contactKeywords;

    @Column(name = "speaker_title")
    private String speakerTitle;

    @Column(name = "speaker_description")
    private String speakerDescription;

    @Column(name = "speaker_keywords")
    private String speakerKeywords;

    @Column(name = "committee_title")
    private String committeeTitle;

    @Column(name = "committee_description")
    private String committeeDescription;

    @Column(name = "committee_keywords")
    private String committeeKeywords;

    @Column(name = "callforpapers_title")
    private String callforpapersTitle;

    @Column(name = "callforpapers_description")
    private String callforpapersDescription;

    @Column(name = "callforpapers_keywords")
    private String callforpapersKeywords;

    @Column(name = "topics_title")
    private String topicsTitle;

    @Column(name = "topics_description")
    private String topicsDescription;

    @Column(name = "topics_keywords")
    private String topicsKeywords;

    @Column(name = "venue_title")
    private String venueTitle;

    @Column(name = "venue_description")
    private String venueDescription;

    @Column(name = "venue_keywords")
    private String venueKeywords;

    @Column(name = "visa_title")
    private String visaTitle;

    @Column(name = "visa_description")
    private String visaDescription;

    @Column(name = "visa_keywords")
    private String visaKeywords;

    @Column(name = "invitation_title")
    private String invitationTitle;

    @Column(name = "invitation_description")
    private String invitationDescription;

    @Column(name = "invitation_keywords")
    private String invitationKeywords;

    @Column(name = "terms_title")
    private String termsTitle;

    @Column(name = "terms_description")
    private String termsDescription;

    @Column(name = "terms_keywords")
    private String termsKeywords;

}
