package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.SpeakerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerInfoRepository extends JpaRepository<SpeakerInfo, Integer> {
}
