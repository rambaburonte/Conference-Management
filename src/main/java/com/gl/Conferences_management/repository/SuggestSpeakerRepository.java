package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.SuggestSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestSpeakerRepository extends JpaRepository<SuggestSpeaker, Integer> {
}
