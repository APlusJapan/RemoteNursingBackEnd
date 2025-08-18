package com.aplus.controller;

import com.aplus.entity.UserCheckupRecord;
import com.aplus.repository.UserCheckupRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user-checkup-record")
public class UserCheckupRecordController {
    @Autowired
    private UserCheckupRecordRepository userCheckupRecordRepository;

    @GetMapping("/user/{userId}")
    public List<UserCheckupRecord> getByUserId(@PathVariable String userId) {
        return userCheckupRecordRepository.findByUserIdAndIsDeletedFalseOrderByMeasureDateDesc(userId);
    }

    @GetMapping("/user/{userId}/date/{measureDate}")
    public UserCheckupRecord getByUserIdAndDate(@PathVariable String userId, @PathVariable Date measureDate) {
        return userCheckupRecordRepository.findByUserIdAndMeasureDate(userId, measureDate);
    }

    @PostMapping("")
    public UserCheckupRecord createOrUpdate(@RequestBody UserCheckupRecord record) {
        // 只判断userId和measureDate（当天）
        UserCheckupRecord existing = userCheckupRecordRepository.findByUserIdAndMeasureDate(record.getUserId(), record.getMeasureDate());
        if (existing != null) {
            // 保留ID和原有的createTime
            record.setId(existing.getId());
            record.setCreateTime(existing.getCreateTime()); // 关键：保留原有创建时间
        }
        return userCheckupRecordRepository.save(record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userCheckupRecordRepository.deleteById(id);
    }
}