package com.example.wantlifu.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrdersGoods implements Serializable {
    private Integer id;

    private Integer orderid;

    private Integer goodid;

    private String goodColor;

    private String goodSize;

    private String goodName;

    private Integer goodNum;

    private BigDecimal goodsPrice;

    private String goodsImg;

    private String remark;

    private static final long serialVersionUID = 1L;
    public OrdersGoods(Lifu lifu, Integer count, String size, String color) {
        goodid = lifu.getId();
        goodSize = size;
        goodName = lifu.getName();
        goodColor = color;
        goodsImg = lifu.getPic();
        goodNum = count;
        goodsPrice = new BigDecimal(lifu.getTruePrice()*count);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }

    public String getGoodSize() {
        return goodSize;
    }

    public void setGoodSize(String goodSize) {
        this.goodSize = goodSize;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderid=").append(orderid);
        sb.append(", goodid=").append(goodid);
        sb.append(", goodColor=").append(goodColor);
        sb.append(", goodSize=").append(goodSize);
        sb.append(", goodName=").append(goodName);
        sb.append(", goodNum=").append(goodNum);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}