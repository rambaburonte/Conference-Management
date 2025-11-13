package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.VenueHelpdesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueHelpdeskRepository extends JpaRepository<VenueHelpdesk, Integer> {
}
