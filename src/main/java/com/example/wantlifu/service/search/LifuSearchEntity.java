package com.example.wantlifu.service.search;

/**
 * lifu 查询实体
 *
 * @author want
 * @createTime 2020.01.08.20:51
 */
public class LifuSearchEntity {
    //礼服 名 关键字
    private String keyWord;
    //礼服 品牌
    private int type;
    //价格区间
    private String priceArea;
    //礼服 类型
    private int LifuType;
    //排序依据
    private String orderByKey = "created_time ";
    private String orderType = "desc";
    //礼服状态
    private int status = 1;
    //是否热门
    private int isHot = 0;
    //是否新品
    private int isNew = 0;
    //是否折扣
    private int discount = 0;
    //定制 还是 租聘 -- 大类型
    private int bigType = 1;

    public String getKeyWord() {
        return keyWord;
    }

    public int getBigType() {
        return bigType;
    }

    public void setBigType(int bigType) {
        this.bigType = bigType;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPriceArea() {
        return priceArea;
    }

    public void setPriceArea(String priceArea) {
        this.priceArea = priceArea;
    }

    public int getLifuType() {
        return LifuType;
    }

    public void setLifuType(int lifuType) {
        LifuType = lifuType;
    }

    public String getOrderByKey() {
        return orderByKey;
    }

    public void setOrderByKey(String orderByKey) {
        this.orderByKey = orderByKey;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
