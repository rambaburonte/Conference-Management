package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.RegistrationPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationPricesRepository extends JpaRepository<RegistrationPrices, Integer> {
}
