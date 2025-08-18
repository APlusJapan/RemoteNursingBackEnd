package com.aplus.controller;

import com.aplus.entity.CheckupStandard;
import com.aplus.repository.CheckupStandardRepository;
import com.aplus.repository.ProjectUserMappingMasterRepository;
import com.aplus.entity.ProjectUserMappingMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/checkup-standard")
public class CheckupStandardController {
    @Autowired
    private CheckupStandardRepository checkupStandardRepository;
    @Autowired
    private ProjectUserMappingMasterRepository projectUserMappingMasterRepository;
    @GetMapping("/by-user/{userId}")
    public List<CheckupStandard> getByUserId(@PathVariable String userId) {
        List<ProjectUserMappingMaster> mappings = projectUserMappingMasterRepository.findByUserId(userId);
        List<String> projectIds = mappings.stream()
                .map(ProjectUserMappingMaster::getProjectId)
                .distinct()
                .toList();
        if (projectIds.isEmpty()) return List.of();
        return checkupStandardRepository.findByProjectIdInAndStatus(projectIds, 1);
    }

    @GetMapping("")
    public List<CheckupStandard> getAll() {
        return checkupStandardRepository.findAll();
    }

    @GetMapping("/admin/{adminId}")
    public List<CheckupStandard> getByAdmin(@PathVariable Long adminId) {
        return checkupStandardRepository.findByAdminIdAndStatus(adminId, 1);
    }

    @GetMapping("/project/{projectId}")
    public List<CheckupStandard> getByProject(@PathVariable String projectId) {
        return checkupStandardRepository.findByProjectIdAndStatus(projectId, 1);
    }

    @GetMapping("/admin/{adminId}/project/{projectId}")
    public List<CheckupStandard> getByAdminAndProject(@PathVariable Long adminId, @PathVariable String projectId) {
        return checkupStandardRepository.findByAdminIdAndProjectIdAndStatus(adminId, projectId, 1);
    }

    @PostMapping("")
    public CheckupStandard createOrUpdate(@RequestBody CheckupStandard standard) {
        CheckupStandard existing = null;
        if (standard.getId() != null) {
            existing = checkupStandardRepository.findById(standard.getId()).orElse(null);
        }
        if (existing != null) {
            standard.setCreatedAt(existing.getCreatedAt());
            standard.setUpdatedAt(new java.util.Date());
        } else {
            standard.setCreatedAt(new java.util.Date());
            standard.setUpdatedAt(new java.util.Date());
        }
        return checkupStandardRepository.save(standard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        checkupStandardRepository.deleteById(id);
    }
}
