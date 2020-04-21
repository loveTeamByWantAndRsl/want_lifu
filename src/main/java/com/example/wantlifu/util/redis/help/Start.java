package com.example.wantlifu.util.redis.help;

/**
 * @author want
 * @createTime 2020.02.23.12:07
 */
public enum Start {
    TRADEMARK(1),LIFU(2),LIFUSKU(3);

    int type;
    Start(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
