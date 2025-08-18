package com.aplus.repository;

import com.aplus.entity.ProjectMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectMasterRepository extends JpaRepository<ProjectMaster, Long> {
    List<ProjectMaster> findByAdminId(Long adminId);
    List<ProjectMaster> findByProjectId(String projectId);
    List<ProjectMaster> findByStatus(Integer status);
    List<ProjectMaster> findByIsDeletedFalse();
    ProjectMaster findByAdminIdAndProjectId(Long adminId, String projectId);
}
