package com.aplus.controller;

import com.aplus.entity.DailyCheckinField;
import com.aplus.repository.DailyCheckinFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkin/field")
public class DailyCheckinFieldController {
    @Autowired
    private DailyCheckinFieldRepository fieldRepository;

    @GetMapping("/form/{formId}")
    public List<DailyCheckinField> getFieldsByFormId(@PathVariable Long formId) {
        return fieldRepository.findByFormId(formId);
    }
}
