package com.aplus.repository;

import com.aplus.entity.DailyCheckinField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyCheckinFieldRepository extends JpaRepository<DailyCheckinField, Long> {
    List<DailyCheckinField> findByFormId(Long formId);
}
