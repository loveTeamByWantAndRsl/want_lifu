package com.example.wantlifu.controller.reciveEntity;

/**
 * @author want
 * @createTime 2020.02.15.16:17
 */
public class B {
    private A a1;
    private String s;

    public A getA1() {
        return a1;
    }

    public void setA1(A a1) {
        this.a1 = a1;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "B{" +
                "a1=" + a1 +
                ", s='" + s + '\'' +
                '}';
    }
}
