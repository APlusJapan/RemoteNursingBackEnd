package com.aplus.repository;

import com.aplus.entity.ProjectTeamMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectTeamMasterRepository extends JpaRepository<ProjectTeamMaster, Long> {
    List<ProjectTeamMaster> findByProjectId(String projectId);
    List<ProjectTeamMaster> findByTeamId(String teamId);
    List<ProjectTeamMaster> findByStatus(Integer status);
    List<ProjectTeamMaster> findByIsDeletedFalse();
    ProjectTeamMaster findByProjectIdAndTeamId(String projectId, String teamId);
}
