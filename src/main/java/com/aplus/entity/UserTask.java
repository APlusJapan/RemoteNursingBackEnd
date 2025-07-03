package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_task", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "task_id"})},
       indexes = {
           @Index(name = "idx_action_type", columnList = "action_type"),
           @Index(name = "idx_start_time", columnList = "start_time"),
           @Index(name = "idx_status", columnList = "action_status")
       })
public class UserTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false, length = 10)
    private String userId;

    @Column(name = "task_id", nullable = false, length = 10)
    private String taskId;

    @Column(name = "task_type", nullable = false, length = 2)
    private String taskType;

    @Column(name = "action_type", nullable = false, length = 2)
    private String actionType;

    @Column(name = "action_status", length = 1)
    private String actionStatus;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted = false;

    @Column(name = "task_name", length = 100)
    private String taskName;

    @Column(name = "task_order")
    private Integer taskOrder;

    // getter/setter 省略
    // ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskOrder() {
        return taskOrder;
    }

    public void setTaskOrder(Integer taskOrder) {
        this.taskOrder = taskOrder;
    }

    public UserTask() {
        this.isDeleted = false;
    }
}
