package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.service.search.LifuSearchEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 礼服的查询 的接收实体
 *
 * @author want
 * @createTime 2020.02.16.15:08
 */
public class LifuReciveEntity extends ReciveEntity{
    @NotNull(message = "参数错误！礼服查询实体不能为空！")
    @Valid
    private LifuSearchEntity lifuSearchEntity;

    public LifuSearchEntity getLifuSearchEntity() {
        return lifuSearchEntity;
    }

    public void setLifuSearchEntity(LifuSearchEntity lifuSearchEntity) {
        this.lifuSearchEntity = lifuSearchEntity;
    }
}
