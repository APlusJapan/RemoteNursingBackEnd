package com.aplus.repository;

import com.aplus.entity.QuestionnaireRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QuestionnaireRecordRepository extends JpaRepository<QuestionnaireRecord, Long> {
    Optional<QuestionnaireRecord> findByUserIdAndFormIdAndFieldId(String userId, Long formId, Long fieldId);
}
