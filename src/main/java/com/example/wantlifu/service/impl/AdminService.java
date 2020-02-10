package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.AdminMapper;
import com.example.wantlifu.entity.Admin;
import com.example.wantlifu.entity.AdminExample;
import com.example.wantlifu.util.JwtTokenUtil;
import com.example.wantlifu.util.StaticPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员
 *
 * @author want
 * @createTime 2020.01.08.19:56
 */
@Service
public class AdminService {
    private static Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Qualifier("adminDetailService")
    @Autowired
    UserDetailsService adminDetailsService;
    /**
     * 加载 管理员 通过 管理员名
     * @param name
     * @return
     */
    public Admin loadAdminByName(String name) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);
        if( admins == null )
            return null;
        if( admins.isEmpty() )
            return null;
        return admins.get(0);
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     */
    public Map<String, String> login(String username, String password) {
        Map<String,String> res = new HashMap<>();
        try{
            UserDetails details = adminDetailsService.loadUserByUsername(username);

            boolean b = encoder.matches(password, details.getPassword());
            if(!b){
                logger.warn("password not true : "+username);
                throw new BadCredentialsException("用户名或密码不正确");
            }
            UsernamePasswordAuthenticationToken uToken = new UsernamePasswordAuthenticationToken(details,username,details.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(uToken);

            String token = jwtTokenUtil.generateToken(details);
            res.put(StaticPool.SUCCESS,token);
        }catch (AuthenticationException e){
            logger.warn("login error : "+e.getMessage());
            res.put(StaticPool.ERROR,e.getMessage());
        }
        return res;
    }

}
