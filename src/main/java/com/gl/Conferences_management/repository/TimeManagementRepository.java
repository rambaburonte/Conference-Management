package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.TimeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeManagementRepository extends JpaRepository<TimeManagement, Integer> {
}
