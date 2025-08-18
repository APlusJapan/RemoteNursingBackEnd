package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_user_mapping_master", uniqueConstraints = {
        @UniqueConstraint(name = "uk_project_user", columnNames = {"project_id", "team_id", "user_id"})
})
public class ProjectUserMappingMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", length = 10, nullable = false)
    private String projectId;

    @Column(name = "team_id", length = 10, nullable = false)
    private String teamId;

    @Column(name = "user_id", length = 15, nullable = false)
    private String userId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getTeamId() { return teamId; }
    public void setTeamId(String teamId) { this.teamId = teamId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
