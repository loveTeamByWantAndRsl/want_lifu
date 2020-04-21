package com.example.wantlifu.base;

import com.example.wantlifu.util.StaticPool;

/**
 * @author 王志坚
 * @createTime 2019.11.25.21:13
 */
public class ApiResponseFactory {
    public static ApiResponse genApiResponse(int code,String message){
        return new ApiResponse(code,message);
    }
    public static ApiResponse genSuccessApiResponse(String message,Object data){
        return new ApiResponse(ApiResponse.Status.SUCCESS.getCode(),message,data);
    }
    public static ApiResponse genSuccessApiResponse(Object data){
        return genSuccessApiResponse(StaticPool.SUCCESS,data);
    }
    public static ApiResponse genSuccessApiResponse(String message){
        return new ApiResponse(ApiResponse.Status.SUCCESS.getCode(),message);
    }
    public static ApiResponse genNotLoginApiResponse(){
        return new ApiResponse(ApiResponse.Status.NOT_LOGIN.getCode(),ApiResponse.Status.NOT_LOGIN.getMsg());
    }

    public static ApiResponse genFailApiResponse(String message) {
        return new ApiResponse(ApiResponse.Status.SERVER_ERROR.getCode(),message);
    }
}
