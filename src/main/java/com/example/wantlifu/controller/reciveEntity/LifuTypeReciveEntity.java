package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.entity.Message;
import com.example.wantlifu.service.impl.LifuTypeService;
import com.example.wantlifu.service.search.LifuSearchEntity;
import com.example.wantlifu.service.search.LifuTypeSearchEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 礼服类型 接收 实体
 *
 * @author want
 * @createTime 2020.02.24.23:05
 */
public class LifuTypeReciveEntity extends ReciveEntity{

    @NotNull(message="礼服查询 实体 不能为空")
    @Valid
    LifuTypeSearchEntity lifuTypeSearchEntity;


    public LifuTypeSearchEntity getLifuTypeSearchEntity() {
        return lifuTypeSearchEntity;
    }

    public void setLifuTypeSearchEntity(LifuTypeSearchEntity lifuTypeSearchEntity) {
        this.lifuTypeSearchEntity = lifuTypeSearchEntity;
    }
}
