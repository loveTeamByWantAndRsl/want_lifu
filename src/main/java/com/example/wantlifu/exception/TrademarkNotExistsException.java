package com.example.wantlifu.exception;

/**
 *
 * 品牌不存在 异常
 *
 * @author want
 * @createTime 2020.03.07.21:53
 */
public class TrademarkNotExistsException extends RuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public TrademarkNotExistsException() {
        super( "品牌id 错误！该品牌不存在！");
    }
}
