package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_point_account")
public class UserPointAccount {
    @Id
    @Column(name = "user_id", length = 15)
    private String userId;
    @Column(name = "total_point", nullable = false)
    private Integer totalPoint = 0;
    @Column(name = "available_point", nullable = false)
    private Integer availablePoint = 0;
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
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Integer getTotalPoint() { return totalPoint; }
    public void setTotalPoint(Integer totalPoint) { this.totalPoint = totalPoint; }
    public Integer getAvailablePoint() { return availablePoint; }
    public void setAvailablePoint(Integer availablePoint) { this.availablePoint = availablePoint; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Date updatedTime) { this.updatedTime = updatedTime; }
}
