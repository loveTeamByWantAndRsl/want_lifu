package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.AboutUs;
import com.example.wantlifu.service.impl.AboutUsService;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author want
 * @createTime 2020.04.08.20:22
 */
@RestController
public class AboutUsController {

    @Autowired
    AboutUsService aboutUsService;

    @RequestMapping("/about-us/get")
    public ApiResponse getAboutUs(){
        return ApiResponseFactory.genSuccessApiResponse(aboutUsService.getAboutUs());
    }
    @PostMapping("/admin/about-us/update")
    public ApiResponse updateAboutUs(@RequestBody AboutUs aboutUs){
        Map<String, String> map = aboutUsService.updateAboutUs(aboutUs);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
}
