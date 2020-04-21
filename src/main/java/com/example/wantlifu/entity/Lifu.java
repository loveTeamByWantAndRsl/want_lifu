package com.example.wantlifu.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Lifu implements Serializable {
    private Integer id;

    @NotNull(message = "礼服名字不能为空！")
    private String name;

    @NotNull(message = "礼服描述不能为空！")
    private String detal;

    @NotNull(message = "商品图片不能为空不能为空！")
    private String pic;

    private Integer buyCount = 0;

    private Integer commentCount = 0;

    private Integer loveCount = 0;

    private Integer isHot = 0;

    private Integer discount = 0;

    private Integer warningCount = 0;

    private Integer isNew = 1;

    private Date createTime;
    @NotNull(message = "礼服品牌不能为空")
    private Integer trademarkId;
    @NotNull(message = "真实价格不能为空")
    private Float truePrice;
    @NotNull(message = "原始（标签）价格不能为空")
    private Float originPrice;

    private Integer count = 0;

    private String remark;

    private String remark1;
    @NotNull(message = "上架/下架状态不能为空")
    private Integer status = 1;
    @NotNull(message = "礼服类型不能为空不能为空")
    private Integer typeId;
    @NotNull(message = "必须选择能否被租聘不能为空")
    private Integer canZuPin;

    private Integer showInIndex = 0;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(Integer loveCount) {
        this.loveCount = loveCount;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(Integer trademarkId) {
        this.trademarkId = trademarkId;
    }

    public Float getTruePrice() {
        return truePrice;
    }

    public void setTruePrice(Float truePrice) {
        this.truePrice = truePrice;
    }

    public Float getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Float originPrice) {
        this.originPrice = originPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCanZuPin() {
        return canZuPin;
    }

    public void setCanZuPin(Integer canZuPin) {
        this.canZuPin = canZuPin;
    }

    public Integer getShowInIndex() {
        return showInIndex;
    }

    public void setShowInIndex(Integer showInIndex) {
        this.showInIndex = showInIndex;
    }

    public String getDetal() {
        return detal;
    }

    public void setDetal(String detal) {
        this.detal = detal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pic=").append(pic);
        sb.append(", buyCount=").append(buyCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", loveCount=").append(loveCount);
        sb.append(", isHot=").append(isHot);
        sb.append(", discount=").append(discount);
        sb.append(", warningCount=").append(warningCount);
        sb.append(", isNew=").append(isNew);
        sb.append(", createTime=").append(createTime);
        sb.append(", trademarkId=").append(trademarkId);
        sb.append(", truePrice=").append(truePrice);
        sb.append(", originPrice=").append(originPrice);
        sb.append(", count=").append(count);
        sb.append(", remark=").append(remark);
        sb.append(", remark1=").append(remark1);
        sb.append(", status=").append(status);
        sb.append(", typeId=").append(typeId);
        sb.append(", canZuPin=").append(canZuPin);
        sb.append(", showInIndex=").append(showInIndex);
        sb.append(", detal=").append(detal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}