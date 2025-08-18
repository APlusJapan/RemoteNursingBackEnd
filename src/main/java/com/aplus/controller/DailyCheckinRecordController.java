package com.aplus.controller;

import com.aplus.entity.DailyCheckinRecord;
import com.aplus.repository.DailyCheckinRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/checkin/record")
public class DailyCheckinRecordController {
    @Autowired
    private DailyCheckinRecordRepository recordRepository;

    @PostMapping("")
    public DailyCheckinRecord saveOrUpdate(@RequestBody DailyCheckinRecord record) {
        Optional<DailyCheckinRecord> existing = recordRepository.findByUserIdAndFormIdAndFieldId(
                record.getUserId(), record.getFormId(), record.getFieldId());
        record.setUpdatedTime(new Date());
        if (existing.isPresent()) {
            DailyCheckinRecord old = existing.get();
            record.setId(old.getId());
            record.setCreateTime(old.getCreateTime());
            record.setCheckTime(old.getCheckTime());
            // 既存レコードのcreated/checked/admin/isDeletedも引き継ぐ
        } else {
            record.setCreateTime(new Date());
            record.setCheckTime(new Date());
        }
        return recordRepository.save(record);
    }
}
