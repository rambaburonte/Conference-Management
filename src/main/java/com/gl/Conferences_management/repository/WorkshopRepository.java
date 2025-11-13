package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Integer> {
}
