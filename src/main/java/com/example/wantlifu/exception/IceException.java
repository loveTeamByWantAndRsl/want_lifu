package com.example.wantlifu.exception;

/**
 * @author want
 * @createTime 2020.03.07.21:24
 */
public class IceException extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public IceException(IceOrBack ice) {
        super(ice.getMessage()+"冻结失败！");
    }

}
