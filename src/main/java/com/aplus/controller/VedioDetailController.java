package com.aplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.aplus.repository.VedioTaskDetailRepository;
import com.aplus.entity.VedioTaskDetail;

@RestController
@RequestMapping("/api")
public class VedioDetailController {

    @Autowired
    private VedioTaskDetailRepository vedioTaskDetailRepository;

    // 查询某用户某系列下所有未删除视频明细
    @GetMapping("/videos")
    public List<VedioTaskDetail> getVideos(
        @RequestParam String userId,
        @RequestParam String vedioSeriesId
    ) {
        // isDeleted=0 表示未删除
        return vedioTaskDetailRepository.findByUserIdAndVedioSeriesIdAndIsDeleted(userId, vedioSeriesId, 0);
    }
}
