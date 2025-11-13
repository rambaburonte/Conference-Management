package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Refunds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundsRepository extends JpaRepository<Refunds, Integer> {
}
