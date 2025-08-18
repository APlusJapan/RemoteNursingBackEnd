package com.aplus.controller;

import com.aplus.entity.ProjectUserMappingMaster;
import com.aplus.repository.ProjectUserMappingMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/project-user-mapping")
public class ProjectUserMappingMasterController {
    @Autowired
    private ProjectUserMappingMasterRepository projectUserMappingMasterRepository;

    @GetMapping("")
    public List<ProjectUserMappingMaster> getAll() {
        return projectUserMappingMasterRepository.findAll();
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectUserMappingMaster> getByProject(@PathVariable String projectId) {
        return projectUserMappingMasterRepository.findByProjectId(projectId);
    }

    @GetMapping("/team/{teamId}")
    public List<ProjectUserMappingMaster> getByTeam(@PathVariable String teamId) {
        return projectUserMappingMasterRepository.findByTeamId(teamId);
    }

    @GetMapping("/user/{userId}")
    public List<ProjectUserMappingMaster> getByUser(@PathVariable String userId) {
        return projectUserMappingMasterRepository.findByUserId(userId);
    }

    @PostMapping("")
    public ProjectUserMappingMaster createOrUpdate(@RequestBody ProjectUserMappingMaster mapping) {
        ProjectUserMappingMaster existing = null;
        if (mapping.getId() != null) {
            existing = projectUserMappingMasterRepository.findById(mapping.getId()).orElse(null);
        }
        if (existing != null) {
            mapping.setCreatedAt(existing.getCreatedAt());
        } else {
            mapping.setCreatedAt(new java.util.Date());
        }
        return projectUserMappingMasterRepository.save(mapping);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectUserMappingMasterRepository.deleteById(id);
    }
}
