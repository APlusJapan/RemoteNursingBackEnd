package com.aplus.repository;

import com.aplus.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Integer> {
    List<UserTask> findByUserId(String userId);
}
