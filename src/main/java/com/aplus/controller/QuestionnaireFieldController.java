package com.aplus.controller;

import com.aplus.entity.QuestionnaireField;
import com.aplus.repository.QuestionnaireFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire/field")
public class QuestionnaireFieldController {
    @Autowired
    private QuestionnaireFieldRepository fieldRepository;

    @GetMapping("/form/{formId}")
    public List<QuestionnaireField> getFieldsByForm(@PathVariable Long formId) {
        return fieldRepository.findByFormIdAndIsDeletedFalseOrderBySortOrderAsc(formId);
    }
}
