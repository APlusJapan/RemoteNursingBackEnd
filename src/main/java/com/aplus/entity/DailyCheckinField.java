package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_checkin_field")
public class DailyCheckinField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "form_id", nullable = false)
    private Long formId;

    @Column(name = "field_label", length = 255, nullable = false)
    private String fieldLabel;

    @Column(name = "field_type", length = 50, nullable = false)
    private String fieldType;

    @Column(name = "field_options", columnDefinition = "TEXT")
    private String fieldOptions;

    @Column(name = "field_param", columnDefinition = "TEXT")
    private String fieldParam;

    @Column(name = "is_required")
    private Boolean isRequired = false;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;

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

    // getter/setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getFormId() { return formId; }
    public void setFormId(Long formId) { this.formId = formId; }
    public String getFieldLabel() { return fieldLabel; }
    public void setFieldLabel(String fieldLabel) { this.fieldLabel = fieldLabel; }
    public String getFieldType() { return fieldType; }
    public void setFieldType(String fieldType) { this.fieldType = fieldType; }
    public String getFieldOptions() { return fieldOptions; }
    public void setFieldOptions(String fieldOptions) { this.fieldOptions = fieldOptions; }
    public String getFieldParam() { return fieldParam; }
    public void setFieldParam(String fieldParam) { this.fieldParam = fieldParam; }
    public Boolean getIsRequired() { return isRequired; }
    public void setIsRequired(Boolean isRequired) { this.isRequired = isRequired; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Date updatedTime) { this.updatedTime = updatedTime; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}
