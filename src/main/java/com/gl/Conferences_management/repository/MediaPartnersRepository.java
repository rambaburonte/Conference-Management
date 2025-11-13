package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.MediaPartners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaPartnersRepository extends JpaRepository<MediaPartners, Integer> {
}
