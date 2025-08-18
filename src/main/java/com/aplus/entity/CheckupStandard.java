package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checkup_standard", uniqueConstraints = {
        @UniqueConstraint(name = "idx_admin_project_item", columnNames = {"admin_id", "project_id", "item_code"})
})
public class CheckupStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id", nullable = false)
    private Long adminId;

    @Column(name = "project_id", length = 10)
    private String projectId;

    @Column(name = "item_code", length = 64, nullable = false)
    private String itemCode;

    @Column(name = "item_name", length = 128, nullable = false)
    private String itemName;

    @Column(name = "min_value", length = 64)
    private String minValue;

    @Column(name = "max_value", length = 64)
    private String maxValue;

    @Column(name = "value_type", length = 16, nullable = false)
    private String valueType = "INT";

    @Column(name = "unit", length = 32)
    private String unit;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "status")
    private Integer status = 1;

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
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getMinValue() { return minValue; }
    public void setMinValue(String minValue) { this.minValue = minValue; }
    public String getMaxValue() { return maxValue; }
    public void setMaxValue(String maxValue) { this.maxValue = maxValue; }
    public String getValueType() { return valueType; }
    public void setValueType(String valueType) { this.valueType = valueType; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
