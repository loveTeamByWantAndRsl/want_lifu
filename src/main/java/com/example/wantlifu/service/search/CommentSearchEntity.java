package com.example.wantlifu.service.search;

/**
 * 评论 查找 实体
 *
 * @author want
 * @createTime 2020.01.16.20:45
 */
public class CommentSearchEntity {
    //评论 id
    private Integer id;
    // 父级 id
    private Integer fatherId;

    // 评论的 实体 id
    private Integer entityId;
    // 评论的 实体 type
    private Integer entityType;

    //用户id
    private Integer userId;
    //状态
    private Integer status;
    //评分
    private Integer score;
    //排序依据
    private String orderByKey = "time ";
    private String orderType = "desc";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
