package com.example.wantlifu.security;



import com.example.wantlifu.mbg.model.Users;
import com.example.wantlifu.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @author 王志坚
 * @createTime 2019.12.05.21:52
 */
@Service
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    IUsersService usersService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String) authentication.getCredentials();

        Users u = usersService.findUsersByUserName(name);

        if(u == null)
            throw new BadCredentialsException("error");
        if(password.equals(u.getUserpwd())){
            return new UsernamePasswordAuthenticationToken(u.getUsername(),u.getUserpwd(),u.getAuthorities());
        }else
            throw new BadCredentialsException("error");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
