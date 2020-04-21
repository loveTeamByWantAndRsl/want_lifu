package com.example.wantlifu.entity;

import com.example.wantlifu.util.StaticPool;
import com.example.wantlifu.util.order.help.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WtOrder implements Serializable {
    private Integer id;

    //创建时需要
    private Integer userid;
    //创建时需要
    private String userName;
    //创建时需要
    private String address;
    //创建时需要
    private String orderNo;
    //创建时需要
    private Integer ispay = 0;

    private Date payTime;
    //创建时需要
    private Date createdTime;

    private Integer status = OrderStatus.NOT_PAY.getNum();

    private Integer deliverType = 0;

    private Integer isRefund = 0;

    private BigDecimal deliverMoney = new BigDecimal(0);

    private Integer isAppraise = 0;

    private String rejectOtherReason = "";

    private Integer expressId;

    private String expressNo;

    private String tradeNo;

    private Integer showInUser = StaticPool.useful;
    //创建时需要
    private BigDecimal lifuTotalPrice;
    //创建时需要
    private BigDecimal realTotalMoney;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(Integer deliverType) {
        this.deliverType = deliverType;
    }

    public Integer getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
    }

    public BigDecimal getDeliverMoney() {
        return deliverMoney;
    }

    public void setDeliverMoney(BigDecimal deliverMoney) {
        this.deliverMoney = deliverMoney;
    }

    public Integer getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(Integer isAppraise) {
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

    public BigDecimal getRealTotalMoney() {
        return realTotalMoney;
    }

    public void setRealTotalMoney(BigDecimal realTotalMoney) {
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
        sb.append(", payTime=").append(payTime);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", status=").append(status);
        sb.append(", deliverType=").append(deliverType);
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