package com.example.wantlifu.controller.reciveEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author want
 * @createTime 2020.02.15.14:41
 */
public abstract class ReciveEntity {
    @NotNull(message = "页数不能为空！")
    @Min(value = 1,message = "数据不符合规范")
    private Integer start;

    @NotNull(message = "页面大小不能为空！")
    @Min(value = 1,message = "数据不符合规范")
    private Integer pageSize;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
