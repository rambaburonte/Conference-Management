package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.IndianRegReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndianRegReqRepository extends JpaRepository<IndianRegReq, Integer> {
}
