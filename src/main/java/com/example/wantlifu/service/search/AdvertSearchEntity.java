package com.example.wantlifu.service.search;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 广告 查询 实体
 *
 * @author want
 * @createTime 2020.01.10.14:05
 */
public class AdvertSearchEntity {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String key;
//    private int id;
    //排序依据
    private String orderByKey = "created_time ";
    private String orderType = "desc";

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOrderByKey() {
        return orderByKey;
    }

    public void setOrderByKey(String orderByKey) {
        this.orderByKey = orderByKey;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
