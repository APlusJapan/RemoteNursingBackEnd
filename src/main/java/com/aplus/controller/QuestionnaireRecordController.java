package com.aplus.controller;

import com.aplus.entity.QuestionnaireRecord;
import com.aplus.repository.QuestionnaireRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/questionnaire/record")
public class QuestionnaireRecordController {
    @Autowired
    private QuestionnaireRecordRepository recordRepository;

    @PostMapping("")
    public QuestionnaireRecord saveOrUpdate(@RequestBody QuestionnaireRecord record) {
        Optional<QuestionnaireRecord> existing = recordRepository.findByUserIdAndFormIdAndFieldId(
                record.getUserId(), record.getFormId(), record.getFieldId());
        record.setUpdatedTime(new Date());
        if (existing.isPresent()) {
            QuestionnaireRecord old = existing.get();
            // 只更新inputValue和updatedTime，其他字段保持原样
            old.setInputValue(record.getInputValue());
            old.setUpdatedTime(record.getUpdatedTime());
            return recordRepository.save(old);
        } else {
            record.setCreateTime(new Date());
            record.setCheckTime(new Date());
            return recordRepository.save(record);
        }
    }
}
