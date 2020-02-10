package com.example.wantlifu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WtOrder implements Serializable {
    private Integer id;

    private Integer userid;

    private String userName;

    private String address;

    private Integer orderNo;

    private String ispay;

    private Date createdTime;

    private String status;

    private String delivertype;

    private String isRefund;

    private String deliverMoney;

    private String isAppraise;

    private String rejectOtherReason;

    private Integer expressId;

    private String expressNo;

    private String tradeNo;

    private Integer showInUser;

    private BigDecimal lifuTotalPrice;

    private Long realTotalMoney;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivertype() {
        return delivertype;
    }

    public void setDelivertype(String delivertype) {
        this.delivertype = delivertype;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    public String getDeliverMoney() {
        return deliverMoney;
    }

    public void setDeliverMoney(String deliverMoney) {
        this.deliverMoney = deliverMoney;
    }

    public String getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(String isAppraise) {
        this.isAppraise = isAppraise;
    }

    public String getRejectOtherReason() {
        return rejectOtherReason;
    }

    public void setRejectOtherReason(String rejectOtherReason) {
        this.rejectOtherReason = rejectOtherReason;
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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getShowInUser() {
        return showInUser;
    }

    public void setShowInUser(Integer showInUser) {
        this.showInUser = showInUser;
    }

    public BigDecimal getLifuTotalPrice() {
        return lifuTotalPrice;
    }

    public void setLifuTotalPrice(BigDecimal lifuTotalPrice) {
        this.lifuTotalPrice = lifuTotalPrice;
    }

    public Long getRealTotalMoney() {
        return realTotalMoney;
    }

    public void setRealTotalMoney(Long realTotalMoney) {
        this.realTotalMoney = realTotalMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", userName=").append(userName);
        sb.append(", address=").append(address);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", ispay=").append(ispay);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", status=").append(status);
        sb.append(", delivertype=").append(delivertype);
        sb.append(", isRefund=").append(isRefund);
        sb.append(", deliverMoney=").append(deliverMoney);
        sb.append(", isAppraise=").append(isAppraise);
        sb.append(", rejectOtherReason=").append(rejectOtherReason);
        sb.append(", expressId=").append(expressId);
        sb.append(", expressNo=").append(expressNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", showInUser=").append(showInUser);
        sb.append(", lifuTotalPrice=").append(lifuTotalPrice);
        sb.append(", realTotalMoney=").append(realTotalMoney);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}