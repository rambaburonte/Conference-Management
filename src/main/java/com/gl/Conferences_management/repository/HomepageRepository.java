package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Homepage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepageRepository extends JpaRepository<Homepage, Integer> {
}
