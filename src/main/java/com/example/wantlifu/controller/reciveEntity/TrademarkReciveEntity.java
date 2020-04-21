package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.service.search.TrademarkSearchEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author want
 * @createTime 2020.02.24.19:49
 */
public class TrademarkReciveEntity extends ReciveEntity{
    @NotNull(message = "参数错误！品牌查询实体不能为空！")
    @Valid
    private TrademarkSearchEntity trademarkSearchEntity;

    public TrademarkSearchEntity getTrademarkSearchEntity() {
        return trademarkSearchEntity;
    }

    public void setTrademarkSearchEntity(TrademarkSearchEntity trademarkSearchEntity) {
        this.trademarkSearchEntity = trademarkSearchEntity;
    }
}
