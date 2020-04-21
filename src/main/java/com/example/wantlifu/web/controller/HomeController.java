package com.example.wantlifu.web.controller;


import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.service.impl.LifuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 王志坚
 * @createTime 2019.11.25.20:21
 */
@Controller
public class HomeController {

    @Autowired
    LifuService lifuService;
    @GetMapping({"/","/index"})
    public String index(Model m){
        /**
         * 首页轮播
         */
        List<Lifu> indexLunBoLifu = lifuService.getIndexLunBoLifu();
        //新品
        List<Lifu> newLifu = lifuService.indexNewLifu();
        //折扣
        List<Lifu> disCountLifu = lifuService.indexDisCountLifu();
        //热门
        List<Lifu> hotLifu = lifuService.indexHotLifu();
        //精选
        List<Lifu> bestLifu = lifuService.indexBestLifu();
        m.addAttribute("indexLunBoLifu",indexLunBoLifu);
        m.addAttribute("newLifu",newLifu);
        m.addAttribute("disCountLifu",disCountLifu);
        m.addAttribute("hotLifu",hotLifu);
        m.addAttribute("bestLifu",bestLifu);
        m.addAttribute("name","want");
        return "index";
    }

    @GetMapping("testApi")
    @ResponseBody
    public ApiResponse apiTest(){
        return ApiResponseFactory.genSuccessApiResponse("success");
    }
}
