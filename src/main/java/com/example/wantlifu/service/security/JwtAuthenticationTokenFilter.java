package com.example.wantlifu.service.security;



import com.example.wantlifu.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 * Created by macro on 2018/4/26.
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private UserDetailsService adminDetailService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
//        String authHeader = request.getHeader(this.tokenHeader);
//        if(authHeader == null){
        if(SecurityContextHolder.getContext().getAuthentication() != null)
            chain.doFilter(request, response);

        String authHeader = null;
                Cookie[] cookies = request.getCookies();
            if(cookies != null && cookies.length > 0){
                for (Cookie c : cookies){
                    if(c.getName().equals(this.tokenHead) ){
                        authHeader = c.getValue();
                        break;
                    }
                }
            }

//        }

        if (authHeader != null) {// && authHeader.startsWith(this.tokenHead)
            //String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authHeader);
            Integer id = jwtTokenUtil.getEntityIdForToken(authHeader);
            Integer cid = jwtTokenUtil.getCompanyIdForToken(authHeader);
            String roles = jwtTokenUtil.getRolesForToken(authHeader);
            String headImg = jwtTokenUtil.getHeadImgForToken(authHeader);
            String nickName = jwtTokenUtil.getNickNameForToken(authHeader);

            LOGGER.info("checking username:{}", username);
            UserDetails userDetails = new OnlineEntity(id,cid,username,headImg,roles,nickName);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            LOGGER.info("authenticated user:{}", username);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
