package com.gl.Conferences_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AcadBusiness")
@Data
public class AcadBusiness {

    private String content;

    private String category;

    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;

}
