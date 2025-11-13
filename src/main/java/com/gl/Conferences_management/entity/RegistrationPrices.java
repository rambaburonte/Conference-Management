package com.gl.Conferences_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "registration_prices")
@Data
public class RegistrationPrices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "speaker_reg_e")
    private String speakerRegE;

    @Column(name = "delegate_reg_e")
    private String delegateRegE;

    @Column(name = "student_reg_e")
    private String studentRegE;

    @Column(name = "poster_reg_e")
    private String posterRegE;

    @Column(name = "speaker_reg_s")
    private String speakerRegS;

    @Column(name = "delegate_reg_s")
    private String delegateRegS;

    @Column(name = "student_reg_s")
    private String studentRegS;

    @Column(name = "poster_reg_s")
    private String posterRegS;

    @Column(name = "speaker_reg_o")
    private String speakerRegO;

    @Column(name = "delegate_reg_o")
    private String delegateRegO;

    @Column(name = "student_reg_o")
    private String studentRegO;

    @Column(name = "poster_reg_o")
    private String posterRegO;

    @Column(name = "one_night_single_occupancy")
    private String oneNightSingleOccupancy;

    @Column(name = "one_night_double_occupancy")
    private String oneNightDoubleOccupancy;

    @Column(name = "two_night_single_occupancy")
    private String twoNightSingleOccupancy;

    @Column(name = "two_night_double_occupancy")
    private String twoNightDoubleOccupancy;

    @Column(name = "three_night_single_occupancy")
    private String threeNightSingleOccupancy;

    @Column(name = "three_night_double_occupancy")
    private String threeNightDoubleOccupancy;

    @Column(name = "four_night_single_occupancy")
    private String fourNightSingleOccupancy;

    @Column(name = "four_night_double_occupancy")
    private String fourNightDoubleOccupancy;

    private String category;

    private Integer user;

    @Column(name = "recordListingID")
    private Integer recordListingId;

}
