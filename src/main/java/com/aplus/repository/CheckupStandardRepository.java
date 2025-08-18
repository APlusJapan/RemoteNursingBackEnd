package com.aplus.repository;

import com.aplus.entity.CheckupStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CheckupStandardRepository extends JpaRepository<CheckupStandard, Long> {
    List<CheckupStandard> findByAdminIdAndStatus(Long adminId, Integer status);
    List<CheckupStandard> findByProjectIdAndStatus(String projectId, Integer status);
    List<CheckupStandard> findByAdminIdAndProjectIdAndStatus(Long adminId, String projectId, Integer status);
    CheckupStandard findByAdminIdAndProjectIdAndItemCode(Long adminId, String projectId, String itemCode);
    List<CheckupStandard> findByProjectIdInAndStatus(List<String> projectIds, Integer status);
}
