package com.example.wantlifu.web.controller.admin;



import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王志坚
 * @createTime 2019.11.26.11:09
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
//    @Autowired
//    UsersMapper usersMapper;
//
//    @RequestMapping("/userList")
//    public ApiResponse getUsers(@RequestParam(value = "start",defaultValue = "0")Integer start
//            ,@RequestParam(value = "pageSize",defaultValue = "4") Integer pageSize){
//        PageHelper.startPage(start,pageSize);
//        List<Users> users = usersMapper.selectByExample(new UsersExample());
//        PageInfo<Users> pageInfo = PageInfo.of(users);
//        return ApiResponseFactory.genSuccessApiResponse("success",pageInfo);
//    }
}
