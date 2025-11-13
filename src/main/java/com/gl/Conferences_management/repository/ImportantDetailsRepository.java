package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.ImportantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportantDetailsRepository extends JpaRepository<ImportantDetails, Integer> {
}
