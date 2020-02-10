package com.example.wantlifu.service.search;



/**
 * @author want
 * @createTime 2020.02.06.11:01
 *
 * 博客 查询 实体
 */
public class UserCommentSearchEntity {
    private String title;
    private Integer status = 1;
    //排序依据
    private String orderByKey = "time ";
    private String orderType = "desc";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
