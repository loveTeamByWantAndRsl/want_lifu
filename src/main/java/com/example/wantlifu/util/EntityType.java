package com.example.wantlifu.util;

/**
 * @author want
 * @createTime 2020.04.07.15:40
 */
public enum EntityType {
    LIFU_TYPE(1)
    ,TRADE_MARK_TYPE(2)
    ,COMMOENT_TYPE(3);

    Integer entityType;

    EntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public Integer getEntityType() {
        return entityType;
    }
}
