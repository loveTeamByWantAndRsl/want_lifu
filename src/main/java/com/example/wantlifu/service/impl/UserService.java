package com.example.wantlifu.service.impl;

import com.example.wantlifu.mbg.mapper.UsersMapper;
import com.example.wantlifu.mbg.model.Users;
import com.example.wantlifu.mbg.model.UsersExample;
import com.example.wantlifu.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王志坚
 * @createTime 2019.12.07.10:45
 */
@Service
public class UserService implements IUsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users findUsersByUserName(String userName) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(userName);

        List<Users> users = usersMapper.selectByExample(usersExample);


        return users == null ? null : users.get(0);
    }
}
