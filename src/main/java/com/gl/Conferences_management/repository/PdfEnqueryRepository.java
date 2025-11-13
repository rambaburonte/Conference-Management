package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.PdfEnquery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfEnqueryRepository extends JpaRepository<PdfEnquery, Integer> {
}
