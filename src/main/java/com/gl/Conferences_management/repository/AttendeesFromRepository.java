package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.AttendeesFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeesFromRepository extends JpaRepository<AttendeesFrom, Integer> {
}
