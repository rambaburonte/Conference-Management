package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.EditSymposia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditSymposiaRepository extends JpaRepository<EditSymposia, Integer> {
}
