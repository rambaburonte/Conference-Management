package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.KeynoteSpeakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeynoteSpeakersRepository extends JpaRepository<KeynoteSpeakers, Integer> {
}
