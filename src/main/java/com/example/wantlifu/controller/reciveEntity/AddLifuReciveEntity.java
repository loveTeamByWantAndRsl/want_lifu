package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.Message;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author want
 * @createTime 2020.02.18.14:18
 */
public class AddLifuReciveEntity {
    @NotNull(message="参数错误！品牌id不能为null")
    @Min(value = 1,message = "id不能小于等于0！")
    private Integer id;
    @Valid
    @NotNull(message="参数错误！礼服实体不能为null")
    private Lifu lifu;
}
