package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Unsubscribes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnsubscribesRepository extends JpaRepository<Unsubscribes, Integer> {
}
