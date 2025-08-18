package com.aplus.controller;

import com.aplus.entity.ProjectTeamMaster;
import com.aplus.repository.ProjectTeamMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/project-team-master")
public class ProjectTeamMasterController {
    @Autowired
    private ProjectTeamMasterRepository projectTeamMasterRepository;

    @GetMapping("")
    public List<ProjectTeamMaster> getAll() {
        return projectTeamMasterRepository.findAll();
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectTeamMaster> getByProject(@PathVariable String projectId) {
        return projectTeamMasterRepository.findByProjectId(projectId);
    }

    @GetMapping("/team/{teamId}")
    public List<ProjectTeamMaster> getByTeam(@PathVariable String teamId) {
        return projectTeamMasterRepository.findByTeamId(teamId);
    }

    @PostMapping("")
    public ProjectTeamMaster createOrUpdate(@RequestBody ProjectTeamMaster team) {
        return projectTeamMasterRepository.save(team);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectTeamMasterRepository.deleteById(id);
    }
}
