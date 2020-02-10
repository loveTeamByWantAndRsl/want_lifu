package com.example.wantlifu.service.security;

import cn.hutool.json.JSONUtil;
import com.example.wantlifu.base.ApiResponseFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当未登录或者token失效访问接口时，自定义的返回结果
 * Created by macro on 2018/5/14.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String requestType = request.getHeader("X-Requested-With");
        if(requestType == null){
            String baseUrl = request.getRequestURI().replace(request.getContextPath(),"");
            String fatherUrl = baseUrl.substring(0,baseUrl.indexOf("/",1));
            if(!"/admin".equals(fatherUrl))
                fatherUrl = "/user";
            response.sendRedirect(fatherUrl+"/loginPage");
            return;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ApiResponseFactory.genFailApiResponse(authException.getMessage())));
        response.getWriter().flush();
    }
}
