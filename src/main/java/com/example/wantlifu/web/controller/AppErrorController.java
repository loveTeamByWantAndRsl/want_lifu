package com.example.wantlifu.web.controller;


import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * web 全局 错误 处理
 *
 * @author 王志坚
 * @createTime 2019.11.25.21:21
 */
@Controller
public class AppErrorController extends BasicErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    private ApplicationContext applicationContext;

    /**
     * 初始化 错误 信息
     * @return
     */
    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
                request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);

        int code = myGetStatus(request);
        String path=model.get("path").toString();
        String fPath = "";
        switch (code){
            case 403:
                fPath += "403";
                break;
            case 404:
                fPath +=  "404";
                break;
            case 500:
                fPath +=  "500";
                break;
            default:
                fPath +=  "index";
            }
        return new ModelAndView(fPath);
    }

    /**
     * API 接口 的 错误 返回
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request){
        //从这里 获取 错误 信息
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        String msg = String.valueOf(requestAttributes.getAttribute("message",1));




        ApiResponse apiResponse = ApiResponseFactory.genApiResponse(myGetStatus(request)
                , msg);
        return apiResponse;
    }
    private int myGetStatus(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return status != null ? status : 500;
    }


}
