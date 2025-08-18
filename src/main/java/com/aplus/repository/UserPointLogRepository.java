package com.aplus.repository;

import com.aplus.entity.UserPointLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserPointLogRepository extends JpaRepository<UserPointLog, Long> {
    List<UserPointLog> findByUserIdOrderByCreateTimeDesc(String userId);
}
