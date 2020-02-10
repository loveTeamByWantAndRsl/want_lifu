package com.example.wantlifu.service.security;

import cn.hutool.json.JSONUtil;
import com.example.wantlifu.base.ApiResponseFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当访问接口没有权限时，自定义的返回结果
 * Created by macro on 2018/4/26.
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        String requestType = request.getHeader("X-Requested-With");
        if(requestType == null){
            String baseUrl = request.getRequestURI().replace(request.getContextPath(),"");
            String fatherUrl = baseUrl.substring(0,baseUrl.indexOf("/",1));
            if(!"/admin".equals(fatherUrl))
                fatherUrl = "/user";
            response.sendRedirect(fatherUrl+"/403");
            return;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ApiResponseFactory.genFailApiResponse(e.getMessage())));
        response.getWriter().flush();
    }
}
