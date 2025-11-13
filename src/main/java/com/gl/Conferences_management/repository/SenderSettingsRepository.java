package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.SenderSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderSettingsRepository extends JpaRepository<SenderSettings, Integer> {
}
