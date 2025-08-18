package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_master", uniqueConstraints = {
        @UniqueConstraint(name = "idx_admin_project_item", columnNames = {"admin_id", "project_id"})
})
public class ProjectMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id", nullable = false)
    private Long adminId;

    @Column(name = "project_id", length = 10, nullable = false)
    private String projectId;

    @Column(name = "project_name", length = 64, nullable = false)
    private String projectName;

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

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAdminId() { return adminId; }
    public void setAdminId(Long adminId) { this.adminId = adminId; }
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
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
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
