package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.RenewedSpeakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenewedSpeakersRepository extends JpaRepository<RenewedSpeakers, Integer> {
}
