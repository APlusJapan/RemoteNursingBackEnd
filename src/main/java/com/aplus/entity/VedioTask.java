package com.aplus.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vedio_task",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "task_id", "vedio_task_id", "vedio_series_id"})
)
public class VedioTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键自增

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "task_id", nullable = false)
    private String taskId;

    @Column(name = "vedio_task_id", nullable = false)
    private String vedioTaskId;

    @Column(name = "vedio_series_id", nullable = false)
    private String vedioSeriesId;

    @Column(name = "vedio_series_name")
    private String vedioSeriesName;

    @Column(name = "vedio_order")
    private Integer vedioOrder;

    @Column(name = "vedio_surface_image")
    private String vedioSurfaceImage;

    @Column(name = "vedio_description")
    private String vedioDescription;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "is_deleted")
    private Integer isDeleted;

    public VedioTask() {}
}
