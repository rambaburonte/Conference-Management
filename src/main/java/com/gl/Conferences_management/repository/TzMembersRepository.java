package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.TzMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TzMembersRepository extends JpaRepository<TzMembers, Integer> {
}
