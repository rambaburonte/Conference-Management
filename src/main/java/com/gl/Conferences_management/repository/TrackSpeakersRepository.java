package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.TrackSpeakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackSpeakersRepository extends JpaRepository<TrackSpeakers, Integer> {
}
