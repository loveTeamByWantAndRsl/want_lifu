package com.example.wantlifu.exception;

/**
 * 礼服不存在的 异常
 *
 * @author want
 * @createTime 2020.03.07.21:22
 */
public class LifuNotExistsException extends RuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public LifuNotExistsException() {
        super("不存在 该件礼服！！！");
    }
}
