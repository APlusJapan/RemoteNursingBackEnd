package com.aplus.repository;

import com.aplus.entity.QuestionnaireField;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionnaireFieldRepository extends JpaRepository<QuestionnaireField, Long> {
    List<QuestionnaireField> findByFormIdAndIsDeletedFalseOrderBySortOrderAsc(Long formId);
}
