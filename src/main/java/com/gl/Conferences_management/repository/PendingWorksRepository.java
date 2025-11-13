package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.PendingWorks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingWorksRepository extends JpaRepository<PendingWorks, Integer> {
}
