package com.example.wantlifu.service.search;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author want
 * @createTime 2020.02.25.21:06
 */
public class OrderSearchEntity {

    //用户id
    private Integer userId;
    //用户名
    private String userName;
    //订单号
    private String orderNo;
    //订单状态
    private Integer status;
    //是否支付
    private Integer isPay;
    //1 ： 退款 0：未退款
    private Integer iRefund;
    //支付流水号
    private String tradeNo;
    //快递id
    private Integer expressId;
    //快递单号
    private String expressNo;
    //提取方式
    private Integer deliverType;

    @DateTimeFormat( style = "yyyy-MM-DD")
    private Date start;
    @DateTimeFormat( style = "yyyy-MM-DD")
    private Date end;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getiRefund() {
        return iRefund;
    }

    public void setiRefund(Integer iRefund) {
        this.iRefund = iRefund;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public Integer getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(Integer deliverType) {
        this.deliverType = deliverType;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
