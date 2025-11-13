package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Yrf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YrfRepository extends JpaRepository<Yrf, Integer> {
}
