package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info", indexes = {
    @Index(name = "idx_user_type", columnList = "user_type"),
    @Index(name = "idx_phone", columnList = "phone"),
    @Index(name = "idx_updated_at", columnList = "updated_date")
})
public class UserInfo {
    @Id
    @Column(name = "user_id", length = 15)
    private String userId;

    @Column(name = "user_type", length = 2)
    private String userType;

    @Column(name = "user_org", length = 5)
    private String userOrg;

    @Column(name = "user_name", length = 20)
    private String userName;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "marital_status", length = 20)
    private String maritalStatus;

    @Column(name = "education_level", length = 20)
    private String educationLevel;

    @Column(name = "living_status", length = 20)
    private String livingStatus;

    @Column(name = "job_status", length = 20)
    private String jobStatus;

    @Column(name = "income_per_capita", length = 20)
    private String incomePerCapita;

    @Column(name = "insurance_type", length = 20)
    private String insuranceType;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "admin_id", length = 15)
    private String adminId;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserOrg() {
        return userOrg;
    }
    public void setUserOrg(String userOrg) {
        this.userOrg = userOrg;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
    public String getLivingStatus() {
        return livingStatus;
    }
    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
    }
    public String getJobStatus() {
        return jobStatus;
    }
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    public String getIncomePerCapita() {
        return incomePerCapita;
    }
    public void setIncomePerCapita(String incomePerCapita) {
        this.incomePerCapita = incomePerCapita;
    }
    public String getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public boolean getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public UserInfo() {}
}