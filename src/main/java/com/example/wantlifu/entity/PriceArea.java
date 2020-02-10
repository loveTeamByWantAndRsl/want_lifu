package com.example.wantlifu.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PriceArea implements Serializable {

    private Integer id;
    @NotNull(message="价格区间 类型 不能为空！")
    private Integer type;

    private String express;


    @NotNull(message="价格区间 最小值 不能为空！")
    private Integer min;
    @NotNull(message="价格区间 最大值 不能为空！")
    private Integer max;
    @NotNull(message="有效状态不能为空！")
    private Integer status = 1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExpress() {
        if(express == null)
            express = ""+min+" ~ "+max;
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", express=").append(express);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}