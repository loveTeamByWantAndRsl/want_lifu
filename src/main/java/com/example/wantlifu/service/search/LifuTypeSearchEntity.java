package com.example.wantlifu.service.search;

import javax.validation.constraints.NotNull;

/**
 * 礼服类型 查询 实体
 *
 * @author want
 * @createTime 2020.02.24.23:08
 */
public class LifuTypeSearchEntity {

    @NotNull(message = "礼服类型 查询 实体的 key 不能为 null！")
    private String key;

    @NotNull(message = "礼服类型 查询 实体的 状态 status 不能为 null！")
    private Integer status;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
