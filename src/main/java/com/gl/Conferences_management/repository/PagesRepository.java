package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Pages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesRepository extends JpaRepository<Pages, Integer> {
}
