package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.WorkSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSheetRepository extends JpaRepository<WorkSheet, Integer> {
}
