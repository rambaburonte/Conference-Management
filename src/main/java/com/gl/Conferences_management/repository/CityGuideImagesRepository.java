package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.CityGuideImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityGuideImagesRepository extends JpaRepository<CityGuideImages, Integer> {
}
