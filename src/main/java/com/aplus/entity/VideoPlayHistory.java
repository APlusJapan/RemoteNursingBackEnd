package com.aplus.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "video_play_history", uniqueConstraints = {
    @UniqueConstraint(name = "uq_play_history", columnNames = {"play_history_id", "play_date"})
})
public class VideoPlayHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "play_history_id", length = 10, nullable = false)
    private String playHistoryId;

    @Column(name = "play_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date playDate;

    @Column(name = "user_id", length = 15, nullable = false)
    private String userId;

    @Column(name = "video_series_id", length = 10, nullable = false)
    private String videoSeriesId;

    @Column(name = "video_id", length = 10, nullable = false)
    private String videoId;

    @Column(name = "video_series_name", length = 100)
    private String videoSeriesName;

    @Column(name = "video_name", length = 100)
    private String videoName;


    @Column(name = "play_time", length = 5)
    private String playTime;

    @Column(name = "video_duration", length = 8)
    private String videoDuration;

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getPlayHistoryId() { return playHistoryId; }
    public void setPlayHistoryId(String playHistoryId) { this.playHistoryId = playHistoryId; }
    public Date getPlayDate() { return playDate; }
    public void setPlayDate(Date playDate) { this.playDate = playDate; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getVideoSeriesId() { return videoSeriesId; }
    public void setVideoSeriesId(String videoSeriesId) { this.videoSeriesId = videoSeriesId; }
    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }
    public String getVideoSeriesName() { return videoSeriesName; }
    public void setVideoSeriesName(String videoSeriesName) { this.videoSeriesName = videoSeriesName; }
    public String getVideoName() { return videoName; }
    public void setVideoName(String videoName) { this.videoName = videoName; }
    public String getPlayTime() { return playTime; }
    public void setPlayTime(String playTime) { this.playTime = playTime; }
    public String getVideoDuration() { return videoDuration; }
    public void setVideoDuration(String videoDuration) { this.videoDuration = videoDuration; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(Date updatedTime) { this.updatedTime = updatedTime; }
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
}
