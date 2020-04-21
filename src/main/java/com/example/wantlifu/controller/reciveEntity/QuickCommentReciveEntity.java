package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.service.search.QuickCommentSearchEntity;

/**
 * 快速回复的 接收实体
 *
 * @author want
 * @createTime 2020.02.25.18:14
 */
public class QuickCommentReciveEntity extends ReciveEntity {

    private QuickCommentSearchEntity entity;

    public QuickCommentSearchEntity getEntity() {
        return entity;
    }

    public void setEntity(QuickCommentSearchEntity entity) {
        this.entity = entity;
    }
}
