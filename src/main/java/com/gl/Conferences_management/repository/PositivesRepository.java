package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Positives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositivesRepository extends JpaRepository<Positives, Integer> {
}
