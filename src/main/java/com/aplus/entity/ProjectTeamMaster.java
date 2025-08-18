package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_team_master", uniqueConstraints = {
        @UniqueConstraint(name = "idx_admin_project_item", columnNames = {"project_id", "team_id"})
})
public class ProjectTeamMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", length = 10, nullable = false)
    private String projectId;

    @Column(name = "team_id", length = 10, nullable = false)
    private String teamId;

    @Column(name = "team_name", length = 128, nullable = false)
    private String teamName;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "status")
    private Integer status = 1;

    @Column(name = "default_flg")
    private Boolean defaultFlg = false;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getTeamId() { return teamId; }
    public void setTeamId(String teamId) { this.teamId = teamId; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Boolean getDefaultFlg() { return defaultFlg; }
    public void setDefaultFlg(Boolean defaultFlg) { this.defaultFlg = defaultFlg; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
