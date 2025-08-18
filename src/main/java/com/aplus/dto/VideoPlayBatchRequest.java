package com.aplus.dto;

import com.aplus.entity.VideoPlayHistory;
import java.util.List;

public class VideoPlayBatchRequest {
    private List<VideoPlayHistory> records;

    public List<VideoPlayHistory> getRecords() { return records; }
    public void setRecords(List<VideoPlayHistory> records) { this.records = records; }
}
