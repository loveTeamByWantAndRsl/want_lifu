package com.example.wantlifu.web.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.exception.TestException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author want
 * @createTime 2020.03.07.21:02
 */
@RestControllerAdvice
public class GlobalExceptionTranslator {

    @ExceptionHandler(TestException.class)
    public ApiResponse test(TestException e){
        return ApiResponseFactory.genFailApiResponse(e.getMessage());
    }
}
