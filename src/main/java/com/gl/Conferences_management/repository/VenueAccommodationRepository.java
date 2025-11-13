package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.VenueAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueAccommodationRepository extends JpaRepository<VenueAccommodation, Integer> {
}
