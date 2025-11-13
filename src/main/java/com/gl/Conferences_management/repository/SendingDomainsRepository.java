package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.SendingDomains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendingDomainsRepository extends JpaRepository<SendingDomains, Integer> {
}
