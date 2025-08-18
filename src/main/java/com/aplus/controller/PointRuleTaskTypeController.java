package com.aplus.controller;

import com.aplus.entity.PointRuleTaskType;
import com.aplus.repository.PointRuleTaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/point/rule")
public class PointRuleTaskTypeController {
    @Autowired
    private PointRuleTaskTypeRepository pointRuleTaskTypeRepository;

    @GetMapping("")
    public List<PointRuleTaskType> getAll() {
        return pointRuleTaskTypeRepository.findAll();
    }

    @GetMapping("/{taskType}")
    public PointRuleTaskType getByTaskType(@PathVariable String taskType) {
        return pointRuleTaskTypeRepository.findById(taskType).orElse(null);
    }

    @PostMapping("")
    public PointRuleTaskType createOrUpdate(@RequestBody PointRuleTaskType rule) {
        return pointRuleTaskTypeRepository.save(rule);
    }
}
