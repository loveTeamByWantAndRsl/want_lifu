package com.example.wantlifu.base;

/**
 * API 格式 封装 以应对 http响应码 的 不足
 *
 * @author 王志坚
 * @createTime 2019.11.25.21:04
 */
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private boolean more;

    public ApiResponse() {
        code = Status.SUCCESS.getCode();
        message = Status.SUCCESS.getMsg();
    }

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public enum Status{
        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad request"),
        INTERNET_SERVER_ERROR(500,"Unknown internet error"),
        NOT_VALID_PARAM(40005,"Not valid params"),
        NOT_SUPPORT_OPERATION(40006,"Operation not support"),
        NOT_LOGIN(50000,"You have not login");

        int code;
        String msg;

        Status(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
