package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.SubTracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTracksRepository extends JpaRepository<SubTracks, Integer> {
}
