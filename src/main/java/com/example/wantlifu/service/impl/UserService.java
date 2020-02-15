package com.example.wantlifu.service.impl;


import com.example.wantlifu.dao.UserMapper;
import com.example.wantlifu.entity.User;
import com.example.wantlifu.entity.UserExample;
import com.example.wantlifu.service.search.UserSearchEntity;
import com.example.wantlifu.util.JwtTokenUtil;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper UserMapper;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    /**
     * 忘记密码
     * @param emailCode
     * @param newPassword
     * @param code
     * @return
     */
    public Map<String, String> forgetPassword(String emailCode, String newPassword, String code) {
        Map<String,String> res = new HashMap<>();

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(emailCode);

        List<User> User = UserMapper.selectByExample(example);
        if( User == null ){
            res.put(StaticPool.ERROR,"修改失败！该email错误！");
            return res;
        }

        if( User.isEmpty() ){
            res.put(StaticPool.ERROR,"修改失败！该email错误！");
            return res;
        }
        String code2 = (String) redisTemplate.opsForValue().get(emailCode);
        //code 正确
        if(code.equalsIgnoreCase(code2)){
            User u = User.get(0);
            String password = encoder.encode(newPassword);
            u.setPassword(password);
            UserMapper.updateByPrimaryKeySelective(u);
            res.put(StaticPool.SUCCESS,"修改成功！");
        }else {
            res.put(StaticPool.ERROR,"修改失败！验证码错误！");
        }

        return res;
    }
    /**
     * 通过用户名加载 用户
     * @param username
     * @return
     */
    public User loadUserByName(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> User = UserMapper.selectByExample(example);
        if( User == null )
            return null;
        if( User.isEmpty() )
            return null;
        return User.get(0);
    }

    /**
     * 刷新 token
     *
     * @param username
     * @return
     */
    public String reFereshToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken uToken = new UsernamePasswordAuthenticationToken(userDetails,userDetails.getUsername(),userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(uToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }


    /**
     * 通过用户名加载 用户
     * @param username
     * @return
     */
    public Map<String,String> login(String username, String password) {
        Map<String,String> res = new HashMap<>();
        try{
            UserDetails details = userDetailsService.loadUserByUsername(username);

            boolean b = encoder.matches(password,details.getPassword());
            if(!b){
                logger.warn("password not true : "+username);
                throw new BadCredentialsException("用户名或密码不正确");
            }
            UsernamePasswordAuthenticationToken uToken = new UsernamePasswordAuthenticationToken(details,username,details.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(uToken);
//            eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMiLCJjcmVhdGVkIjoxNTc2ODk0MzExOTAyLCJleHAiOjE1Nzc0OTkxMTF9.b5xK5XC8EQHNjYFSQzfHICNupwbZp43oxVQMaBkM_DRaY1FpRfplM8taLsuf9mjYG0XRG8T9oQ3F86_UCaZL3w
            String token = jwtTokenUtil.generateToken(details);
            res.put(StaticPool.SUCCESS,token);
        }catch (AuthenticationException e){
            logger.warn("login error : "+e.getMessage());
            res.put(StaticPool.ERROR,e.getMessage());
        }
        return res;
    }
    /**
     * 用户注册
     * @param u
     * @return
     */
    public Map<String, String> addUser(User u) {
        //检查用户名 是否 重复
        //检查email 是否 重复

        Map<String,String> result = new HashMap<>();

        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(u.getUsername());
        example.or().andEmailEqualTo(u.getEmail());
        List<User> User = UserMapper.selectByExample(example);
        if(User != null && User.size() > 0){
            result.put(StaticPool.ERROR,"用户名 或 email 已存在");
            return result;
        }
        //设置 默认状态
        //增加 创建时间
        u.setPassword(encoder.encode(u.getPassword()));
        u.setStatus(0);
        u.setCreateTime(new Date());
        int res = UserMapper.insert(u);
        if(res > 0){
            result.put(StaticPool.SUCCESS,"注册成功！");
        }else {
            result.put(StaticPool.ERROR,"系统繁忙");
        }
        return result;
    }
    /**
     * 找回密码
     * @return
     */
    public Map<String, String> updateUserPassword(Integer id,String oldPwd,String newPwd) {
        //id是否合法

        Map<String,String> result = new HashMap<>();

        User u = UserMapper.selectByPrimaryKey(id);
        if(u == null){
            result.put(StaticPool.ERROR,"id 错误！");
            return result;
        }
        //旧密码的正确性
        if( encoder.matches(oldPwd,u.getPassword()) ){
            u.setPassword(encoder.encode(u.getPassword()));
            int res = UserMapper.updateByPrimaryKey(u);
            if(res > 0){
                result.put(StaticPool.SUCCESS,"修改成功！");
            }else {
                result.put(StaticPool.ERROR,"系统繁忙");
            }
        }else {
            result.put(StaticPool.ERROR,"旧密码 错误！");
        }
        return result;
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    public Map<String, String> updateInfo(User user) {
        //id是否合法
        int id = user.getId();
        Map<String,String> result = new HashMap<>();

        User u = UserMapper.selectByPrimaryKey(id);
        if(u == null){
            result.put(StaticPool.ERROR,"id 错误！");
            return result;
        }
        u.setHeadUrl(user.getHeadUrl());
        u.setNickName(user.getNickName());
        u.setPhone(user.getPhone());
        int res = UserMapper.updateByPrimaryKeySelective(u);
        if(res > 0){
            result.put(StaticPool.SUCCESS,"修改个人信息成功！");
        }else {
            result.put(StaticPool.ERROR,"系统繁忙");
        }
        return result;
    }
    /**
     * 按条件查询 用户
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo<User> queryUser(Integer start, Integer pageSize, UserSearchEntity entity) {
        Map<String,String> result = new HashMap<>();
        PageHelper.startPage(start,pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        // key
        if( !StringUtils.isEmpty(entity.getKeyWord()))
            criteria.andUsernameLike(entity.getKeyWord()+"%");
        // status
        if( entity.getStatus() != null && entity.getStatus() >= 0)
            criteria.andStatusEqualTo(entity.getStatus());
        example.setOrderByClause(entity.getOrderKey()+entity.getOrderBy());
        List<User> User = UserMapper.selectByExample(example);
        PageInfo<User> pageInfo = PageInfo.of(User);
        return pageInfo;
    }
    /**
     * 按照 用户 的email 查询
     * @param email
     * @return
     */
    public User queryUserByEmail(String email) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email);
        List<User> User = UserMapper.selectByExample(example);
        if( User == null )
            return null;
        if( User.isEmpty() )
            return null;
        return User.get(0);
    }
    /**
     * 按照 id查询
     * @param id
     * @return
     */
    public User queryUserById(Integer id) {
        return UserMapper.selectByPrimaryKey(id);
    }


    /**
     * 冻结用户
     */
    public Map<String, String> iceUserById(Integer id){
        return changeUserStatusById(id,StaticPool.notUseful);
    }

    public Map<String, String> updateOrIceUsersByIds(Integer[] ids){
        for(Integer id : ids){
            if(!iceUserById(id).containsKey(StaticPool.SUCCESS))
                throw new RuntimeException("冻结出错！");
        }
        return StaticPool.genSuccessRes();
    }

    /**
     * 修改用户状态
     * @param id
     * @param status
     * @return
     */
    public Map<String,String> changeUserStatusById(Integer id,Integer status){
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        int flag = UserMapper.updateByPrimaryKeySelective(user);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

//    public List<User> queryAllUses() {
//        UserExample example = new UserExample();
//        example.createCriteria();
//        List<User> list = UserMapper.selectByExample(example);
//        return list;
//    }

}
