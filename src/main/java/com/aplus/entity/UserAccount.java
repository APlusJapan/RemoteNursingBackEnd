package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_account", indexes = {
    @Index(name = "uk_login_name", columnList = "login_name", unique = true),
    @Index(name = "idx_user_id", columnList = "user_id")
})
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "user_id", length = 15, nullable = false)
    private String userId;

    @Column(name = "login_name", length = 50, nullable = false, unique = true)
    private String loginName;

    @Column(name = "password_hash", length = 100, nullable = false)
    private String passwordHash;

    @Column(name = "salt", length = 50)
    private String salt;

    @Column(name = "login_status", length = 10)
    private String loginStatus = "active";

    @Column(name = "login_fail_count")
    private Integer loginFailCount = 0;

    @Column(name = "last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;


    @Column(name = "last_login_ip", length = 45)
    private String lastLoginIp;

    @Column(name = "admin_id", length = 15)
    private String adminId;


    @Column(name = "nick_name", length = 50)
    private String nickName;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getLoginId() { return loginId; }
    public void setLoginId(Long loginId) { this.loginId = loginId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getLoginName() { return loginName; }
    public void setLoginName(String loginName) { this.loginName = loginName; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }
    public String getLoginStatus() { return loginStatus; }
    public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }
    public Integer getLoginFailCount() { return loginFailCount; }
    public void setLoginFailCount(Integer loginFailCount) { this.loginFailCount = loginFailCount; }
    public Date getLastLoginTime() { return lastLoginTime; }
    public void setLastLoginTime(Date lastLoginTime) { this.lastLoginTime = lastLoginTime; }
    public String getLastLoginIp() { return lastLoginIp; }
    public void setLastLoginIp(String lastLoginIp) { this.lastLoginIp = lastLoginIp; }

    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public String getNickName() { return nickName; }
    public void setNickName(String nickName) { this.nickName = nickName; }
}
