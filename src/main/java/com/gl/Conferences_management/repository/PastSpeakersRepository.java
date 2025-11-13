package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.PastSpeakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastSpeakersRepository extends JpaRepository<PastSpeakers, Integer> {
}
