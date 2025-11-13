package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepository extends JpaRepository<Topics, Integer> {
}
