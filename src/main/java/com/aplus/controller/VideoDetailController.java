package com.aplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.aplus.repository.VideoTaskDetailRepository;
import com.aplus.entity.VideoTaskDetail;

@RestController
@RequestMapping("/api")
public class VideoDetailController {
    // 指定シリーズIDの全動画明細（未削除）取得
    @GetMapping("/video-detail/series/{videoSeriesId}")
    public List<VideoTaskDetail> getVideosBySeriesId(@PathVariable String videoSeriesId) {
        return videoTaskDetailRepository.findByVideoSeriesIdAndIsDeleted(videoSeriesId, 0);
    }

    @Autowired
    private VideoTaskDetailRepository videoTaskDetailRepository;

    // 查询某用户某系列下所有未删除视频明细
    @GetMapping("/video-detail")
    public List<VideoTaskDetail> getVideos(
        @RequestParam String userId,
        @RequestParam String videoSeriesId
    ) {
        // isDeleted=0 表示未删除
        return videoTaskDetailRepository.findByUserIdAndVideoSeriesIdAndIsDeleted(userId, videoSeriesId, 0);
    }
}
