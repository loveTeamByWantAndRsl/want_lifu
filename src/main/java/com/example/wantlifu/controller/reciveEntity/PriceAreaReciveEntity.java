package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.service.search.PriceAreaSearchEntity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 价格区间的接受参数
 *
 * @author want
 * @createTime 2020.02.15.14:38
 */
public class PriceAreaReciveEntity extends ReciveEntity{

    @NotNull(message = "参数错误！价格区间查询实体不能为空！")
    @Valid
    private PriceAreaSearchEntity priceAreaSearchEntity;


    public PriceAreaSearchEntity getPriceAreaSearchEntity() {
        return priceAreaSearchEntity;
    }

    public void setPriceAreaSearchEntity(PriceAreaSearchEntity priceAreaSearchEntity) {
        this.priceAreaSearchEntity = priceAreaSearchEntity;
    }

}
