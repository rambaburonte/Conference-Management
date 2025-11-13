package com.gl.Conferences_management.repository;

import com.gl.Conferences_management.entity.DailyTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyTasksRepository extends JpaRepository<DailyTasks, Integer> {
}
