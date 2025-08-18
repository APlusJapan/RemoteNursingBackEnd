package com.aplus.controller;

import com.aplus.entity.VideoPlayHistory;
import com.aplus.repository.VideoPlayHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aplus.dto.VideoPlayBatchRequest;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

@RestController
@RequestMapping("/api/video-play-history")
public class VideoPlayHistoryController {

    @Autowired
    private VideoPlayHistoryRepository videoPlayHistoryRepository;

    @GetMapping("/user/{userId}")
    public List<VideoPlayHistory> getByUserId(@PathVariable String userId) {
        return videoPlayHistoryRepository.findByUserIdAndIsDeletedFalseOrderByPlayDateDesc(userId);
    }


    @PostMapping("")
    public VideoPlayHistory createOrUpdate(@RequestBody VideoPlayHistory record) {
        return videoPlayHistoryRepository.save(record);
    }

    // バッチ登録API
    @PostMapping("/batch")
    public List<VideoPlayHistory> batchCreateOrUpdate(@RequestBody VideoPlayBatchRequest batchRequest) {
        return videoPlayHistoryRepository.saveAll(batchRequest.getRecords());
    }
    // 添加批量处理接口
    @PostMapping("/batch-update")
    public Map<String, Object> batchUpdate(@RequestBody Map<String, Object> requestData) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 解析请求数据
            String userId = (String) requestData.get("userId");
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> records = (List<Map<String, Object>>) requestData.get("records");
            
            if (userId == null || userId.isEmpty()) {
                result.put("success", false);
                result.put("message", "用户ID不能为空");
                return result;
            }
            
            if (records == null || records.isEmpty()) {
                result.put("success", false);
                result.put("message", "播放记录不能为空");
                return result;
            }
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            
            // 处理每条记录
            for (Map<String, Object> recordMap : records) {
                VideoPlayHistory history = new VideoPlayHistory();
                
                // 生成播放历史ID
                history.setPlayHistoryId("PH" + System.currentTimeMillis() % 100000000);
                
                // 设置基本信息
                history.setUserId(userId);
                history.setVideoId((String) recordMap.get("videoId"));
                history.setVideoSeriesId((String) recordMap.get("videoSeriesId"));
                history.setVideoName((String) recordMap.get("videoName"));
                history.setVideoSeriesName((String) recordMap.get("videoSeriesName"));
                history.setAdminId((String) recordMap.get("adminId"));
                // 重要：转换并设置日期
                try {
                    String playDateStr = (String) recordMap.get("playDate");
                    if (playDateStr != null && !playDateStr.isEmpty()) {
                        Date playDate = dateFormat.parse(playDateStr);
                        history.setPlayDate(playDate);
                    } else {
                        // 如果前端没有传日期，使用当前日期
                        history.setPlayDate(now);
                    }
                } catch (ParseException e) {
                    // 日期解析失败，使用当前日期
                    history.setPlayDate(now);
                    System.err.println("日期解析失败: " + recordMap.get("playDate"));
                }
                
                // 设置播放时长
                Object playTimeObj = recordMap.get("playTime");
                if (playTimeObj instanceof Integer) {
                    history.setPlayTime(String.valueOf(playTimeObj));
                } else if (playTimeObj instanceof String) {
                    history.setPlayTime((String) playTimeObj);
                } else {
                    history.setPlayTime("0");
                }

                // 设置视频时长
                Object videoDurationObj = recordMap.get("videoDuration");
                if (videoDurationObj instanceof String) {
                    history.setVideoDuration((String) videoDurationObj);
                } else {
                    history.setVideoDuration("");
                }
                
                // 设置时间戳
                history.setCreateTime(now);
                history.setUpdatedTime(now);
                history.setIsDeleted(false);
                
                // 保存到数据库
                videoPlayHistoryRepository.save(history);
            }
            
            result.put("success", true);
            result.put("message", "批量上传成功");
            result.put("count", records.size());
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "批量上传失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        return result;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        videoPlayHistoryRepository.deleteById(id);
    }
}
