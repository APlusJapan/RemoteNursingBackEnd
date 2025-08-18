package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_checkin_record", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "form_id", "field_id"}))
public class DailyCheckinRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 15, nullable = false)
    private String userId;

    @Column(name = "form_id", nullable = false)
    private Long formId;

    @Column(name = "field_id", nullable = false)
    private Long fieldId;

    @Column(name = "input_value", columnDefinition = "TEXT")
    private String inputValue;

    @Column(name = "check_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkTime;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "admin_id", length = 15)
    private String adminId;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Long getFormId() { return formId; }
    public void setFormId(Long formId) { this.formId = formId; }
    public Long getFieldId() { return fieldId; }
    public void setFieldId(Long fieldId) { this.fieldId = fieldId; }
    public String getInputValue() { return inputValue; }
    public void setInputValue(String inputValue) { this.inputValue = inputValue; }
    public Date getCheckTime() { return checkTime; }
    public void setCheckTime(Date checkTime) { this.checkTime = checkTime; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Date updatedTime) { this.updatedTime = updatedTime; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}
