package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.HotelExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelExpensesRepository extends JpaRepository<HotelExpenses, Integer> {
}
