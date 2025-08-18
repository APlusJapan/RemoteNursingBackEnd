package com.aplus.controller;

import com.aplus.entity.VideoTask;
import com.aplus.repository.VideoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class VideoTaskController {
    // 指定ユーザーのVideoTask一覧取得
    @GetMapping("/video-task/user/{userId}")
    public List<VideoTask> getVideoTasksByUserId(@PathVariable String userId) {
        return videoTaskRepository.findByUserIdAndIsDeleted(userId, 0);
    }

    @Autowired
    private VideoTaskRepository videoTaskRepository;

    // 获取全部未删除系列（可加userId参数筛选）
    @GetMapping("/video-task")
    public List<VideoTask> getAllSeries(
            @RequestParam(required = false) String userId) {
        if (userId != null && !userId.isEmpty()) {
            return videoTaskRepository.findByUserIdAndIsDeleted(userId, 0);
        } else {
            return videoTaskRepository.findByIsDeleted(0);
        }
    }
}
