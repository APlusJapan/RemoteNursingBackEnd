package com.aplus.repository;

import com.aplus.entity.ProjectUserMappingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectUserMappingMasterRepository extends JpaRepository<ProjectUserMappingMaster, Long> {
    List<ProjectUserMappingMaster> findByProjectId(String projectId);
    List<ProjectUserMappingMaster> findByTeamId(String teamId);
    List<ProjectUserMappingMaster> findByUserId(String userId);
    List<ProjectUserMappingMaster> findByProjectIdAndTeamId(String projectId, String teamId);
    List<ProjectUserMappingMaster> findByProjectIdAndUserId(String projectId, String userId);
    List<ProjectUserMappingMaster> findByTeamIdAndUserId(String teamId, String userId);
    ProjectUserMappingMaster findByProjectIdAndTeamIdAndUserId(String projectId, String teamId, String userId);
}
