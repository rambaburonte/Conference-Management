package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "venue_hospitality")
@Data
public class VenueHospitality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String map;

    @Column(name = "venue_content")
    private String venueContent;

    @Column(name = "venue_image1")
    private String venueImage1;

    @Column(name = "image_title1")
    private String imageTitle1;

    @Column(name = "venue_image2")
    private String venueImage2;

    @Column(name = "image_title2")
    private String imageTitle2;

    @Column(name = "venue_image3")
    private String venueImage3;

    @Column(name = "image_title3")
    private String imageTitle3;

}
