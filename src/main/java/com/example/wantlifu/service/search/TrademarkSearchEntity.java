package com.example.wantlifu.service.search;

/**
 * @author want
 * @createTime 2020.02.05.22:11
 *
 * 品牌 查询实体
 */
public class TrademarkSearchEntity {
    private String name;


//    private String orderKey = "create_time ";
//    private String orderBy = "desc";

    private String firstChar;
    private Integer status = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
