package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.service.impl.LifuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * lifu操作控制器
 *
 * @author want
 * @createTime 2020.02.15.15:20
 */
@Controller
public class LifuController {

    @Autowired
    LifuService lifuService;

    @RequestMapping("admin/lifu/addLifu")
    public ApiResponse addLifu(Lifu lifu){
        lifuService.addLifu(lifu);
        return ApiResponseFactory.genSuccessApiResponse("success");
    }
}
