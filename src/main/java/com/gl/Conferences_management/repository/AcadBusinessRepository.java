package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.AcadBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcadBusinessRepository extends JpaRepository<AcadBusiness, Integer> {
}
