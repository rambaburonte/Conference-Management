package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.CityAttractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityAttractionsRepository extends JpaRepository<CityAttractions, Integer> {
}
