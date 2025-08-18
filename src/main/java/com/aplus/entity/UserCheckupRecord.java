package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

@Entity
@Table(name = "user_checkup_record", uniqueConstraints = {
        @UniqueConstraint(name = "uq_user_time", columnNames = {"user_id", "measure_date"})
})
public class UserCheckupRecord {
    @PrePersist
    protected void onCreate() {
        if (this.createTime == null) {
            this.createTime = new Date();
        }
        this.updateTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        // createTimeは既存値を保持
        this.updateTime = new Date();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", length = 15, nullable = false)
    private String userId;

    @Column(name = "measure_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date measureDate;

    @Column(name = "steps")
    private Integer steps = 0;

    @Column(name = "heart_rate")
    private Integer heartRate = 0;

    @Column(name = "spo2")
    private Integer spo2 = 0;

    @Column(name = "low_blood_pressure")
    private Integer lowBloodPressure = 0;

    @Column(name = "high_blood_pressure")
    private Integer highBloodPressure = 0;

    @Column(name = "blood_glucose", precision = 5, scale = 2)
    private BigDecimal bloodGlucose;

    @Column(name = "sleep_quality")
    private Integer sleepQuality = 0;

    @Column(name = "wake_count")
    private Integer wakeCount = 0;

    @Column(name = "deep_sleep_time")
    private Integer deepSleepTime = 0;

    @Column(name = "light_sleep_time")
    private Integer lightSleepTime = 0;

    @Column(name = "all_sleep_time")
    private Integer allSleepTime = 0;

    @Column(name = "sleep_down")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Shanghai")
    private Date sleepDown;

    @Column(name = "sleep_up")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Shanghai")
    private Date sleepUp;

    @Column(name = "admin_id", length = 15)
    private String adminId;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Date getMeasureDate() { return measureDate; }
    public void setMeasureDate(Date measureDate) { this.measureDate = measureDate; }
    public Integer getSteps() { return steps; }
    public void setSteps(Integer steps) { this.steps = steps; }
    public Integer getHeartRate() { return heartRate; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }
    public Integer getSpo2() { return spo2; }
    public void setSpo2(Integer spo2) { this.spo2 = spo2; }
    public Integer getLowBloodPressure() { return lowBloodPressure; }
    public void setLowBloodPressure(Integer lowBloodPressure) { this.lowBloodPressure = lowBloodPressure; }
    public Integer getHighBloodPressure() { return highBloodPressure; }
    public void setHighBloodPressure(Integer highBloodPressure) { this.highBloodPressure = highBloodPressure; }
    public BigDecimal getBloodGlucose() { return bloodGlucose; }
    public void setBloodGlucose(BigDecimal bloodGlucose) { this.bloodGlucose = bloodGlucose; }
    public Integer getSleepQuality() { return sleepQuality; }
    public void setSleepQuality(Integer sleepQuality) { this.sleepQuality = sleepQuality; }
    public Integer getWakeCount() { return wakeCount; }
    public void setWakeCount(Integer wakeCount) { this.wakeCount = wakeCount; }
    public Integer getDeepSleepTime() { return deepSleepTime; }
    public void setDeepSleepTime(Integer deepSleepTime) { this.deepSleepTime = deepSleepTime; }
    public Integer getLightSleepTime() { return lightSleepTime; }
    public void setLightSleepTime(Integer lightSleepTime) { this.lightSleepTime = lightSleepTime; }
    public Integer getAllSleepTime() { return allSleepTime; }
    public void setAllSleepTime(Integer allSleepTime) { this.allSleepTime = allSleepTime; }
    public Date getSleepDown() { return sleepDown; }
    public void setSleepDown(Date sleepDown) { this.sleepDown = sleepDown; }
    public Date getSleepUp() { return sleepUp; }
    public void setSleepUp(Date sleepUp) { this.sleepUp = sleepUp; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}
