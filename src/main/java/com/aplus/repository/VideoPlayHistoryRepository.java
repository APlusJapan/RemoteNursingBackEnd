package com.aplus.repository;

import com.aplus.entity.VideoPlayHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoPlayHistoryRepository extends JpaRepository<VideoPlayHistory, Integer> {
    List<VideoPlayHistory> findByUserIdAndIsDeletedFalseOrderByPlayDateDesc(String userId);
}
