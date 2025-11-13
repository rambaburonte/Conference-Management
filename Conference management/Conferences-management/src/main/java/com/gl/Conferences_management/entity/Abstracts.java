package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "abstracts")
@Data
public class Abstracts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sno;

    private String title;

    private String name;

    private String surname;

    private String country;

    @Column(name = "Authors_Email")
    private String authorsEmail;

    @Column(name = "Alternative_Email")
    private String alternativeEmail;

    @Column(name = "Abstract_Category")
    private String abstractCategory;

    @Column(name = "Abstract")
    private String abstractContent;

    @Column(name = "Full_Postal_Address")
    private String fullPostalAddress;

    @Column(name = "Attach_your_file")
    private String attachYourFile;

}
