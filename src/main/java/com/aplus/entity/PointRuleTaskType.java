package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "point_rule_task_type")
public class PointRuleTaskType {
    @Id
    @Column(name = "task_type", length = 2)
    private String taskType;
    @Column(name = "point_amount", nullable = false)
    private Integer pointAmount = 0;
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
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Integer getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
