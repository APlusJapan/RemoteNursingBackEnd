package com.aplus.controller;

import com.aplus.entity.UserPointLog;
import com.aplus.repository.UserPointLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/point/log")
public class UserPointLogController {
    @Autowired
    private UserPointLogRepository userPointLogRepository;

    @GetMapping("/user/{userId}")
    public List<UserPointLog> getLogsByUserId(@PathVariable String userId) {
        return userPointLogRepository.findByUserIdOrderByCreateTimeDesc(userId);
    }

    @PostMapping("")
    public UserPointLog create(@RequestBody UserPointLog log) {
        UserPointLog existing = null;
        if (log.getId() != null) {
            existing = userPointLogRepository.findById(log.getId()).orElse(null);
        }
        if (existing != null) {
            // createTimeを保持
            log.setCreateTime(existing.getCreateTime());
            log.setUpdatedTime(new java.util.Date());
        } else {
            log.setCreateTime(new java.util.Date());
            log.setUpdatedTime(new java.util.Date());
        }
        return userPointLogRepository.save(log);
    }
}
