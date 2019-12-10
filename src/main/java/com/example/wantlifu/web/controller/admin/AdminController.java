package com.example.wantlifu.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王志坚
 * @createTime 2019.11.26.11:09
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/404")
    public String page404(){
        return "/admin/404";
    }
    @GetMapping("/basic_table")
    public String basic_table(){
        return "/admin/basic_table";
    }
    @GetMapping("/blank")
    public String blank(){
        return "/admin/blank";
    }
    @GetMapping("/buttons")
    public String buttons(){
        return "/admin/buttons";
    }
    @GetMapping("/chart-chartjs")
    public String chart_chartjs(){
        return "/admin/chart-chartjs";
    }
    @GetMapping("/form_component")
    public String form_component(){
        return "/admin/form_component";
    }
    @GetMapping("/form_validation")
    public String form_validation(){
        return "/admin/form_validation";
    }
    @GetMapping("/general")
    public String general(){
        return "/admin/general";
    }
    @GetMapping("/grids")
    public String grids(){
        return "/admin/grids";
    }
    @GetMapping("/index")
    public String index(){
        return "/admin/index";
    }
    @GetMapping("/login")
    public String login(){
        return "/admin/login";
    }
    @GetMapping("/profile")
    public String profile(){
        return "/admin/profile";
    }
    @GetMapping("/widgets")
    public String widgets(){
        return "/admin/widgets";
    }
}
