package com.gl.Conferences_management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "daily_tasks")
@Data
public class DailyTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private Integer user;

    @Column(name = "assigned_by")
    private String assignedBy;

    private LocalDate date;

    private String sec1;

    private String sec2;

    private String sec3;

    private String sec4;

    private String sec5;

    private String sec6;

    private String sec7;

    private String sec8;

    private String sec9;

    private String remarks;

    @Column(name = "sec1_reply")
    private String sec1Reply;

    @Column(name = "sec2_reply")
    private String sec2Reply;

    @Column(name = "sec3_reply")
    private String sec3Reply;

    @Column(name = "sec4_reply")
    private String sec4Reply;

    @Column(name = "sec5_reply")
    private String sec5Reply;

    @Column(name = "sec6_reply")
    private String sec6Reply;

    @Column(name = "sec7_reply")
    private String sec7Reply;

    @Column(name = "sec8_reply")
    private String sec8Reply;

    @Column(name = "sec9_reply")
    private String sec9Reply;

}
