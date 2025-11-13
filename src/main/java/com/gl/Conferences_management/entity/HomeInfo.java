package com.gl.Conferences_management.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "home_info")
@Data
public class HomeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user;

    private String data;

    private String image;

    private String aimage;

    private String pdf;

    private String info3;

    private String info4;

    private Integer status;

    private LocalDate date;

}
