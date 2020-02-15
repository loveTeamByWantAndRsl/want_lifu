package com.example.wantlifu.service.search;

/**
 * @author want
 * @createTime 2020.02.05.19:48
 *
 * 价格 区间 查询 实体
 *
 */
public class PriceAreaSearchEntity {
    private String express;
    private Integer status = 1;

    private Integer min;

    private Integer max;

    private Integer type;
    //排序依据
//    private String orderByKey = "created_time ";
//    private String orderType = "desc";


    public PriceAreaSearchEntity() {
    }

    public PriceAreaSearchEntity(String express, Integer status, Integer min, Integer max,Integer type) {
        this.express = express;
        this.status = status;
        this.min = min;
        this.max = max;
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
