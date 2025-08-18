package com.aplus.controller;

import com.aplus.entity.ProjectMaster;
import com.aplus.repository.ProjectMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/project-master")
public class ProjectMasterController {
    @Autowired
    private ProjectMasterRepository projectMasterRepository;

    @GetMapping("")
    public List<ProjectMaster> getAll() {
        return projectMasterRepository.findAll();
    }

    @GetMapping("/admin/{adminId}")
    public List<ProjectMaster> getByAdmin(@PathVariable Long adminId) {
        return projectMasterRepository.findByAdminId(adminId);
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectMaster> getByProject(@PathVariable String projectId) {
        return projectMasterRepository.findByProjectId(projectId);
    }

    @PostMapping("")
    public ProjectMaster createOrUpdate(@RequestBody ProjectMaster project) {
        return projectMasterRepository.save(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectMasterRepository.deleteById(id);
    }
}
