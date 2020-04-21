package com.example.wantlifu.web.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.*;
import com.example.wantlifu.service.impl.*;
import com.example.wantlifu.service.search.CommentSearchEntity;
import com.example.wantlifu.service.security.LoginEntityHelper;
import com.example.wantlifu.util.EntityType;
import com.example.wantlifu.util.StaticPool;
import com.example.wantlifu.web.recevi.entity.LoginEntity;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 王志坚
 * @createTime 2019.11.29.9:40
 */
@Controller
public class UserController {

    @Autowired
    LifuService lifuService;
    @Autowired
    PictureService pictureService;
    @Autowired
    CommentService commentService;
    @Autowired
    TrademarkService trademarkService;
    @Autowired
    LifuSkuService lifuSkuService;
    @Autowired
    AboutUsService aboutUsService;
    @Autowired
    AboutService aboutService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserService userService;
    @Value("${jwt.tokenHead}")
    String tokenHead;
    @Autowired
    UserAddressService addressService;
    @Autowired
    LoginEntityHelper loginEntityHelper;

    @PostMapping("/user/register")
    @ResponseBody
    public ApiResponse register(@RequestBody JSONObject jsonObject){
        ApiResponse result = null;

        String code = (String) jsonObject.get("code");
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        String email = (String) jsonObject.get("email");
        if(org.springframework.util.StringUtils.isEmpty(code) ||
                org.springframework.util.StringUtils.isEmpty(username) ||
                org.springframework.util.StringUtils.isEmpty(password) ||
                org.springframework.util.StringUtils.isEmpty(email)){
            result =  ApiResponseFactory.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        String mail = user.getEmail();
        String code2 = (String) redisTemplate.opsForValue().get(mail);

        if(code.equalsIgnoreCase(code2)){
            redisTemplate.delete(mail);

            Map<String, String> res = userService.addUser(user);
            if( res.get(StaticPool.ERROR) != null ){
                result = ApiResponseFactory.genFailApiResponse(res.get(StaticPool.ERROR));
            }else {
                result = ApiResponseFactory.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
            }
        }else {
            result = ApiResponseFactory.genFailApiResponse("验证码错误！请重新填写！");
        }
        return result;
    }
    @PostMapping("/user/login")
    @ResponseBody
    public ApiResponse result(@RequestBody LoginEntity entity){
        String username = entity.getUsername();
        String password = entity.getPassword();
        String token = null;
        Map<String,String> res;
        if(StringUtils.isEmpty(username)
                || StringUtils.isEmpty(password) ) {
            throw new RuntimeException("params error!");
        }
        res = userService.login(username, password);
        token = res.get(StaticPool.SUCCESS);
        if(token == null)
            return ApiResponseFactory.genFailApiResponse(res.get(StaticPool.ERROR) == null ? "服务繁忙" : res.get(StaticPool.ERROR));
//        response.addHeader(tokenHead,token);
//        response.addCookie(new Cookie(tokenHead,token));
        Map<String,String> map = new HashMap<>();
        map.put("header",tokenHead);
        map.put("token",token);

        return ApiResponseFactory.genSuccessApiResponse(map);
    }
    /**
     * 账号找回
     * @param jsonObject
     * @return
     */
    @PostMapping("/user/findBack")
    @ResponseBody
    public ApiResponse findBack(@RequestBody JSONObject jsonObject){
        ApiResponse result = null;
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");
        String code = (String) jsonObject.get("code");
        if(org.springframework.util.StringUtils.isEmpty(email) || org.springframework.util.StringUtils.isEmpty(password)
                || org.springframework.util.StringUtils.isEmpty(code)){
            result =  ApiResponseFactory.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Map<String, String> res = userService.forgetPassword(email, password, code);
        if( res.get(StaticPool.ERROR) != null ){
            result = ApiResponseFactory.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = ApiResponseFactory.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }


    @GetMapping("/404")
    public String page404(){
        return "/404";
    }
    @GetMapping("/about-us")
    public String about_us(Model m){
        AboutUs aboutUs = aboutUsService.getAboutUs();
        m.addAttribute("aboutUs",aboutUs);
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
    public String product_details(@RequestParam("id") @Min(1)Integer id,Model model){
        //若找不到则返回另一个页面

        Lifu lifu = lifuService.getLifuById(id);
        //查询评论，
        CommentSearchEntity commentSearchEntity = new CommentSearchEntity();

        commentSearchEntity.setEntityId(id);
        commentSearchEntity.setEntityType(EntityType.LIFU_TYPE.getEntityType());
        commentSearchEntity.setStatus(StaticPool.useful);

        PageInfo<Comment> commentPageInfo
                = commentService.selectComment(1, 8, commentSearchEntity);
        //查询图片

        List<Picture> pictures = pictureService.selectPictureByEntity(id, EntityType.LIFU_TYPE.getEntityType());

        //查询品牌信息
        Trademark trademark = trademarkService.selectTrademarkById(lifu.getTrademarkId());
        //查询sku
        List<LifuSku> lifuSkus = lifuSkuService.selectSkuByLifuId(id);
        Set<String> sizes = lifuSkus.stream().map(LifuSku::getSize).collect(Collectors.toSet());
        Set<String> colors = lifuSkus.stream().map(LifuSku::getColor).collect(Collectors.toSet());
        model.addAttribute("lifu",lifu);

        model.addAttribute("pageInfo",commentPageInfo);
        model.addAttribute("pictures",pictures);
        model.addAttribute("trademark",trademark);
        model.addAttribute("sku",lifuSkus);
        model.addAttribute("sizes",sizes);
        model.addAttribute("colors",colors);
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
    public String servers(Model m){
        List<AboutServers> allUseful = aboutService.getAllUseful();
        m.addAttribute("services",allUseful);
        return "/servers";
    }
    @GetMapping("user/changePassword")
    public String changePassword(){
        return "/user/changePassword";
    }
    @GetMapping("user/myAddress")
    public String myAddress(Model m){
        Integer id = loginEntityHelper.getOnlineEntity().getId();
        List<UserAddress> adds = addressService.getAllUsefulAddress(id);
        m.addAttribute("adds",adds);
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
