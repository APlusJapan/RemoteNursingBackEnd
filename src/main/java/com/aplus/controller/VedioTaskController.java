package com.aplus.controller;

import com.aplus.entity.VedioTask;
import com.aplus.repository.VedioTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class VedioTaskController {

    @Autowired
    private VedioTaskRepository vedioTaskRepository;

    // 获取全部未删除系列（可加userId参数筛选）
    @GetMapping("/series")
    public List<VedioTask> getAllSeries(
            @RequestParam(required = false) String userId) {
        if (userId != null && !userId.isEmpty()) {
            return vedioTaskRepository.findByUserIdAndIsDeleted(userId, 0);
        } else {
            return vedioTaskRepository.findByIsDeleted(0);
        }
    }
}
