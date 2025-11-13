package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.HomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeInfoRepository extends JpaRepository<HomeInfo, Integer> {
}
