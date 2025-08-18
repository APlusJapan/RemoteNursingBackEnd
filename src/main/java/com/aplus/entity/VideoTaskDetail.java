package com.aplus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "video_task_detail")
public class VideoTaskDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 自增主键

    @Column(name = "user_id")
    private String userId;

    @Column(name = "video_series_id")
    private String videoSeriesId;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "video_order")
    private Integer videoOrder;

    @Column(name = "video_name")
    private String videoName;
    
    @Column(name = "video_surface_image")
    private String videoSurfaceImage;

    @Column(name = "video_url")
    private String videoURL;

    @Column(name = "video_description")
    private String videoDescription;

    @Column(name = "video_duration")
    private String videoDuration;

    @Column(name = "fouce_now")
    private String fouceNow;

    @Column(name = "is_deleted")
    private Integer isDeleted;
}
