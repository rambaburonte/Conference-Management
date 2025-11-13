package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Subscribes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribesRepository extends JpaRepository<Subscribes, Integer> {
}
