package com.example.wantlifu.exception;

/**
 * @author want
 * @createTime 2020.03.07.21:25
 */
public enum IceOrBack {
    LIFU_SKU("礼服的sku")
    ,LIFU_TYPE("礼服类型")
    ,PRICE_AREA("价格区间")
    ,QUICK_COMMENT("快速回复")
    ,USER("用户");


    private String message;

    IceOrBack(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
