package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.service.search.AboutServiceSearcherEntity;

/**
 * @author want
 * @createTime 2020.04.08.21:01
 */
public class AboutServiceReciveEntity extends ReciveEntity {
    private AboutServiceSearcherEntity entity;

    public AboutServiceSearcherEntity getEntity() {
        return entity;
    }

    public void setEntity(AboutServiceSearcherEntity entity) {
        this.entity = entity;
    }
}
