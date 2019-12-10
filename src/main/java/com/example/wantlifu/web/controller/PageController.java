package com.example.wantlifu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 王志坚
 * @createTime 2019.11.28.19:07
 */
@Controller
public class PageController {


    @GetMapping("/logout/success")
    public String logout_success(){
        return "/logout-success";
    }


}
