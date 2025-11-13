package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pages")
@Data
public class Pages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String faqs;

    private String policies;

    private String guidelines;

    @Column(name = "visa_information")
    private String visaInformation;

    @Column(name = "invitation_letter")
    private String invitationLetter;

    @Column(name = "terms_conditions")
    private String termsConditions;

    private Integer user;

}
