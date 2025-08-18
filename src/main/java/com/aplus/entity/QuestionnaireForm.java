package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "questionnaire_form")
public class QuestionnaireForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "form_name", length = 255, nullable = false)
    private String formName;
    @Column(name = "form_desc", columnDefinition = "TEXT")
    private String formDesc;
    @Column(name = "is_enabled")
    private Boolean isEnabled = true;
    @Column(name = "admin_id", length = 15)
    private String adminId;
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    // getter/setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFormName() { return formName; }
    public void setFormName(String formName) { this.formName = formName; }
    public String getFormDesc() { return formDesc; }
    public void setFormDesc(String formDesc) { this.formDesc = formDesc; }
    public Boolean getIsEnabled() { return isEnabled; }
    public void setIsEnabled(Boolean isEnabled) { this.isEnabled = isEnabled; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Date updatedTime) { this.updatedTime = updatedTime; }
}
