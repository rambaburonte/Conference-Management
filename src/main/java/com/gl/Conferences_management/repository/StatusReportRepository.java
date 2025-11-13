package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.StatusReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusReportRepository extends JpaRepository<StatusReport, Integer> {
}
