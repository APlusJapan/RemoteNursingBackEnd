package com.aplus.repository;

import com.aplus.entity.VedioTaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VedioTaskDetailRepository extends JpaRepository<VedioTaskDetail, Long> {
    // 通过 userId 和 vedioSeriesId 查找所有视频明细
    List<VedioTaskDetail> findByUserIdAndVedioSeriesIdAndIsDeleted(String userId, String vedioSeriesId, Integer isDeleted);
}

