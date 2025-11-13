package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.Invitecolleague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitecolleagueRepository extends JpaRepository<Invitecolleague, Integer> {
}
