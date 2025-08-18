package com.aplus.repository;

import com.aplus.entity.UserCheckupRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface UserCheckupRecordRepository extends JpaRepository<UserCheckupRecord, Integer> {
    List<UserCheckupRecord> findByUserIdAndIsDeletedFalseOrderByMeasureDateDesc(String userId);
    UserCheckupRecord findByUserIdAndMeasureDate(String userId, Date measureDate);
}
