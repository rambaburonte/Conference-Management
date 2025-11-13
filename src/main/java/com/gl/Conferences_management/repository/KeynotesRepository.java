package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Keynotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeynotesRepository extends JpaRepository<Keynotes, Integer> {
}
