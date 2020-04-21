package com.example.wantlifu.controller.reciveEntity;

import com.example.wantlifu.entity.OrdersGoods;

import java.util.List;

/**
 * @author want
 * @createTime 2020.04.13.15:12
 */
public class OrderEntity {

    Double total_amount = 0.0;
    String subject;
    String body;

    private List<OrdersGoods> goods;


    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<OrdersGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<OrdersGoods> goods) {
        this.goods = goods;
    }
}
