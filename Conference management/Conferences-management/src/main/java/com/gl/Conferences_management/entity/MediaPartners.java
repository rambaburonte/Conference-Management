package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "media_partners")
@Data
public class MediaPartners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mediapartner_name")
    private String mediapartnerName;

    private String link;

    private String description;

    private String user;

    private String photo;

}
