package com.aplus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vedio_task_detail")
public class VedioTaskDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 自增主键

    @Column(name = "user_id")
    private String userId;

    @Column(name = "vedio_series_id")
    private String vedioSeriesId;

    @Column(name = "vedio_id")
    private String vedioId;

    @Column(name = "vedio_order")
    private Integer vedioOrder;

    @Column(name = "vedio_name")
    private String vedioName;
    
    @Column(name = "vedio_surface_image")
    private String vedioSurfaceImage;

    @Column(name = "vedio_url")
    private String vedioURL;

    @Column(name = "vedio_description")
    private String vedioDescription;

    @Column(name = "vedio_duration")
    private String vedioDuration;

    @Column(name = "fouce_now")
    private String fouceNow;

    @Column(name = "is_deleted")
    private Integer isDeleted;
}
