package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.CfaSubCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CfaSubCategoriesRepository extends JpaRepository<CfaSubCategories, Integer> {
}
