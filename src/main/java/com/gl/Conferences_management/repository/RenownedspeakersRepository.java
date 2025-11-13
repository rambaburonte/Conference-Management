package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Renownedspeakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenownedspeakersRepository extends JpaRepository<Renownedspeakers, Integer> {
}
