package com.example.wantlifu.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private Integer id;

    private String content;

    private Integer conversationId;

    private Integer sendId;

    private Integer acceptId;

    private Integer showInSend;

    private Integer showInAccept;

    private Date sendTime;

    private Integer status;

    private String remark;

    private String remark1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }

    public Integer getShowInSend() {
        return showInSend;
    }

    public void setShowInSend(Integer showInSend) {
        this.showInSend = showInSend;
    }

    public Integer getShowInAccept() {
        return showInAccept;
    }

    public void setShowInAccept(Integer showInAccept) {
        this.showInAccept = showInAccept;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", conversationId=").append(conversationId);
        sb.append(", sendId=").append(sendId);
        sb.append(", acceptId=").append(acceptId);
        sb.append(", showInSend=").append(showInSend);
        sb.append(", showInAccept=").append(showInAccept);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", remark1=").append(remark1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}