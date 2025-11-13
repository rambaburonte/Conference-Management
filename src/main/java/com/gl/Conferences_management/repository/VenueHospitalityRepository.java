package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.VenueHospitality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueHospitalityRepository extends JpaRepository<VenueHospitality, Integer> {
}
