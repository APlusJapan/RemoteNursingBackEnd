package com.aplus.repository;

import com.aplus.entity.VideoTaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoTaskDetailRepository extends JpaRepository<VideoTaskDetail, Long> {
    // 通过 userId 和 videoSeriesId 查找所有视频明细
    List<VideoTaskDetail> findByUserIdAndVideoSeriesIdAndIsDeleted(String userId, String videoSeriesId, Integer isDeleted);

    // 通过 videoSeriesId 查找所有未删除视频明细
    List<VideoTaskDetail> findByVideoSeriesIdAndIsDeleted(String videoSeriesId, Integer isDeleted);
}

