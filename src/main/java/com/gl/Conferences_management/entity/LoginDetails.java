package com.gl.Conferences_management.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "login_details")
@Data
public class LoginDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    private String email;

    @Column(name = "contact_no")
    private String contactNo;

    private String gender;

    private String address;

    private String status;

    private String role;

    private Integer conference;

    private Integer member;

    private String username;

    @Column(name = "ConfName")
    private String confName;

    private String confvenue;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "assigned_date")
    private String assignedDate;

    @Column(name = "conference_url")
    private String conferenceUrl;

    @Column(name = "event_name")
    private String eventName;

    private String url;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "hostinger_domain")
    private String hostingerDomain;

    @Column(name = "hostinger_domain_1")
    private String hostingerDomain1;

    @Column(name = "otp_time")
    private LocalDateTime otpTime;

    private String otp;

    private LocalDate date;

}
