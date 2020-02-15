package com.example.wantlifu.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.User;
import com.example.wantlifu.service.impl.UserService;
import com.example.wantlifu.service.search.UserSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户操作 控制器
 *
 * @author want
 * @createTime 2020.02.12.10:00
 */
@Controller
public class UserWorkController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/admin/userList")
    //@RequestBody UserSearchEntity userSearchEntity,
    //@RequestParam("key") String key,@RequestParam("status") Integer status,@RequestParam("start") Integer start,@RequestParam("pageSize") Integer pageSize
    public ApiResponse  selectUserByEntity(@RequestBody JSONObject jsonObject){
        if( jsonObject.get("start") == null || jsonObject.get("pageSize") == null
                || jsonObject.get("status") == null || jsonObject.get("key") == null)
            return ApiResponseFactory.genFailApiResponse("参数 错误 ！");
        Integer start = Integer.valueOf(jsonObject.get("start").toString());
        Integer status = Integer.valueOf(jsonObject.get("status").toString());
        Integer pageSize = Integer.valueOf(jsonObject.get("pageSize").toString());
        String key = jsonObject.get("key").toString();
        return ApiResponseFactory.genSuccessApiResponse("success",userService.queryUser(start,pageSize,new UserSearchEntity(key,status)));
    }
    @ResponseBody
    @RequestMapping("/admin/user/iceUser")
    public ApiResponse iceUsersByIds(@RequestBody Integer[] ids){
        Map<String, String> map = userService.updateOrIceUsersByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
}
