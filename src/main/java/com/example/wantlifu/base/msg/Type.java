package com.example.wantlifu.base.msg;

/**
 * @author want
 * @createTime 2020.02.19.13:42
 */
public enum Type {

    DLIFU(1,"删除礼服的类型"),DSKU(2,"删除礼服的sku的类型");

    public static  final String typeStr = "type";

    Type(Integer type,String name){
        this.type = type;
        this.name = name;
    }
    Integer type;
    String name;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
