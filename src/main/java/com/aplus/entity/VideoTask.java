package com.aplus.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "video_task",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "task_id", "video_task_id", "video_series_id"})
)
public class VideoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键自增

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "task_id", nullable = false)
    private String taskId;

    @Column(name = "video_task_id", nullable = false)
    private String videoTaskId;

    @Column(name = "video_series_id", nullable = false)
    private String videoSeriesId;

    @Column(name = "video_series_name")
    private String videoSeriesName;

    @Column(name = "video_order")
    private Integer videoOrder;

    @Column(name = "video_surface_image")
    private String videoSurfaceImage;

    @Column(name = "video_description")
    private String videoDescription;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "is_deleted")
    private Integer isDeleted;

    public VideoTask() {}
}
