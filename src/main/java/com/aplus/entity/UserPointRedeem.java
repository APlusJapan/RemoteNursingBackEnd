package com.aplus.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "user_point_redeem")
public class UserPointRedeem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "redeem_id")
    private Long redeemId;
    @Column(name = "user_id", length = 15, nullable = false)
    private String userId;
    @Column(name = "point_amount", nullable = false)
    private Integer pointAmount;
    @Column(name = "cash_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal cashAmount;
    @Column(name = "status", length = 10, nullable = false)
    private String status = "pending";
    @Column(name = "wechat_account", length = 50, nullable = false)
    private String wechatAccount;
    @Column(name = "admin_id", length = 15)
    private String adminId;
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "reviewed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewedAt;
    @Column(name = "paid_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidAt;
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    public Long getRedeemId() { return redeemId; }
    public void setRedeemId(Long redeemId) { this.redeemId = redeemId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Integer getPointAmount() { return pointAmount; }
    public void setPointAmount(Integer pointAmount) { this.pointAmount = pointAmount; }
    public BigDecimal getCashAmount() { return cashAmount; }
    public void setCashAmount(BigDecimal cashAmount) { this.cashAmount = cashAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getWechatAccount() { return wechatAccount; }
    public void setWechatAccount(String wechatAccount) { this.wechatAccount = wechatAccount; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getReviewedAt() { return reviewedAt; }
    public void setReviewedAt(Date reviewedAt) { this.reviewedAt = reviewedAt; }
    public Date getPaidAt() { return paidAt; }
    public void setPaidAt(Date paidAt) { this.paidAt = paidAt; }
    public Date getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Date updatedTime) { this.updatedTime = updatedTime; }
}
