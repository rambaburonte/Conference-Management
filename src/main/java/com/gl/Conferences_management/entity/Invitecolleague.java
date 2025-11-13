package com.gl.Conferences_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "invitecolleague")
@Data
public class Invitecolleague {

    private String confTitle1;

    private String confTitle2;

    private String cfaurl;

    private String impSessions;

    private String withRegards;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
