package com.example.wantlifu.exception;

/**
 * @author want
 * @createTime 2020.03.07.21:03
 */
public class TestException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     */
    public TestException() {
        super(" this is test global exception advice!");
    }
}
