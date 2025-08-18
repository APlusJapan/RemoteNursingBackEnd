package com.aplus.repository;

import com.aplus.entity.DailyCheckinRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyCheckinRecordRepository extends JpaRepository<DailyCheckinRecord, Long> {
    Optional<DailyCheckinRecord> findByUserIdAndFormIdAndFieldId(String userId, Long formId, Long fieldId);
}
