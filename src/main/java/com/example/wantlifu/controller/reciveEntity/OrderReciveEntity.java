package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.service.search.OrderSearchEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author want
 * @createTime 2020.02.25.21:02
 */
public class OrderReciveEntity extends ReciveEntity {
    @NotNull(message = "订单的查询实体不能为空")
    @Valid OrderSearchEntity entity;

    public OrderSearchEntity getEntity() {
        return entity;
    }

    public void setEntity(OrderSearchEntity entity) {
        this.entity = entity;
    }
}
