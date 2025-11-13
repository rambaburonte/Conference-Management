package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Cityguide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityguideRepository extends JpaRepository<Cityguide, Integer> {
}
