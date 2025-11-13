package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Brochure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrochureRepository extends JpaRepository<Brochure, Integer> {
}
