package com.example.wantlifu.web.controller;


import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王志坚
 * @createTime 2019.11.25.20:21
 */
@Controller
public class HomeController {
    @GetMapping({"/","/index"})
    public String index(Model m){
        m.addAttribute("name","want");
        return "index";
    }

    @GetMapping("testApi")
    @ResponseBody
    public ApiResponse apiTest(){
        return ApiResponseFactory.genSuccessApiResponse("success");
    }
}
