package com.example.wantlifu.entity;

import java.io.Serializable;

public class UserAddress implements Serializable {
    private Integer id;

    private Integer uid;

    private String address;

    private String detail;

    private String reciverName;

    private String reciverPhone;

    private Integer status = 1;

    private Integer defaulted = 0;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName;
    }

    public String getReciverPhone() {
        return reciverPhone;
    }

    public void setReciverPhone(String reciverPhone) {
        this.reciverPhone = reciverPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDefaulted() {
        return defaulted;
    }

    public void setDefaulted(Integer defaulted) {
        this.defaulted = defaulted;
    }

    public String getAllAddress(){
        return address+detail;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", address=").append(address);
        sb.append(", detail=").append(detail);
        sb.append(", reciverName=").append(reciverName);
        sb.append(", reciverPhone=").append(reciverPhone);
        sb.append(", status=").append(status);
        sb.append(", defaulted=").append(defaulted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}