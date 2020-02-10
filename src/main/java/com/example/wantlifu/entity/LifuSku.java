package com.example.wantlifu.entity;

import java.io.Serializable;

public class LifuSku implements Serializable {
    private Integer id;

    private String size;

    private Integer lifuId;

    private String color;

    private Integer count;

    private Float price;

    private Integer status;

    public LifuSku() {
        this.status = 1;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getLifuId() {
        return lifuId;
    }

    public void setLifuId(Integer lifuId) {
        this.lifuId = lifuId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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
        sb.append(", size=").append(size);
        sb.append(", lifuId=").append(lifuId);
        sb.append(", color=").append(color);
        sb.append(", count=").append(count);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}