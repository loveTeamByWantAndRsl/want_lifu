package com.example.wantlifu.exception;

/**
 * @author want
 * @createTime 2020.03.07.21:39
 */
public class ReBackException extends RuntimeException {

    public ReBackException(IceOrBack ice) {
        super(ice.getMessage()+"恢复失败！");
    }
}
