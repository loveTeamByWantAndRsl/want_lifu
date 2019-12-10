package com.example.wantlifu.service;

import com.example.wantlifu.mbg.model.Users;

import java.util.List;

/**
 * @author 王志坚
 * @createTime 2019.12.07.10:44
 */
public interface IUsersService {

    Users findUsersByUserName(String name);
}
