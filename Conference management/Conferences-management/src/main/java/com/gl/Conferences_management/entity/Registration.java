package com.gl.Conferences_management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "registration")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id")
    private Integer regId;

    private String firstname;

    private String lastname;

    private String middlename;

    private String email;

    private String username;

    private String password;

    private String gender;

    @Column(name = "activation_status")
    private String activationStatus;

    @Column(name = "login_status")
    private String loginStatus;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

}
