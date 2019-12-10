package com.example.wantlifu.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 王志坚
 * @createTime 2019.11.29.9:40
 */
@Controller
public class UserController {
    @GetMapping("/404")
    public String page404(){
        return "/404";
    }
    @GetMapping("/about-us")
    public String about_us(){
        return "/about-us";
    }
    @GetMapping("/account")
    public String account(){
        return "/account";
    }
    @GetMapping("/blog-details")
    public String blog_details(){
        return "/blog-details";
    }
    @GetMapping("/cart")
    public String cart(){
        return "/cart";
    }
    @GetMapping("/contact")
    public String contact(){
        return "/contact";
    }
    @GetMapping("/full-width-blog")
    public String full_width_blog(){
        return "/full-width-blog";
    }
    @GetMapping("/left-sidebar-blog")
    public String left_sidebar_blog(){
        return "/left-sidebar-blog";
    }
    @GetMapping("/product-details")
    public String product_details(){
        return "/product-details";
    }
    @GetMapping("/shop")
    public String shop(){
        return "/shop";
    }
    @GetMapping("/wishlist")
    public String wishlist(){
        return "/wishlist";
    }
    @GetMapping("/500")
    public String page500(){
        return "/500";
    }

    @GetMapping("user/userInfo")
    public String userInfo(){
        return "/user/userInfo";
    }
    @GetMapping("servers")
    public String servers(){
        return "/servers";
    }
    @GetMapping("user/changePassword")
    public String changePassword(){
        return "/user/changePassword";
    }
    @GetMapping("user/myAddress")
    public String myAddress(){
        return "/user/myAddress";
    }
    @GetMapping("user/myselfComment")
    public String myselfComment(){
        return "/user/myselfComment";
    }
    @GetMapping("user/myOrders")
    public String myOrders(){
        return "/user/myOrders";
    }
    @GetMapping("user/myMessages")
    public String myMessages(){
        return "/user/myMessages";
    }
}
