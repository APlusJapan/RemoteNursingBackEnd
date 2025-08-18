package com.aplus.repository;

import com.aplus.entity.VideoTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoTaskRepository extends JpaRepository<VideoTask, Long> {
    // 查询某个用户下的全部未删除系列（通用写法）
    List<VideoTask> findByUserIdAndIsDeleted(String userId, Integer isDeleted);

    // 如果你想查全部用户的系列，不加 userId 参数
    List<VideoTask> findByIsDeleted(Integer isDeleted);
}
