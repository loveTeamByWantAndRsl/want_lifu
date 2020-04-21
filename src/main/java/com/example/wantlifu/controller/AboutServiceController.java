package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.AboutServiceReciveEntity;
import com.example.wantlifu.entity.AboutServers;
import com.example.wantlifu.service.impl.AboutService;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.04.08.20:58
 */
@RestController
public class AboutServiceController {
    @Autowired
    AboutService aboutService;

    @PostMapping("/admin/aboutService/add")
    public ApiResponse add(@RequestBody AboutServers aboutServers){
        Map<String, String> map = aboutService.add(aboutServers);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("/admin/aboutService/update")
    public ApiResponse update(@RequestBody AboutServers aboutServers){
        Map<String, String> map = aboutService.update(aboutServers);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("/aboutService/select")
    public ApiResponse select(@RequestBody AboutServiceReciveEntity entity){
        PageInfo<AboutServers> aboutServersPageInfo = aboutService.selectAboutServiceByEntity(
                entity.getStart(), entity.getPageSize(), entity.getEntity());

        return ApiResponseFactory.genSuccessApiResponse(aboutServersPageInfo);
    }
    @RequestMapping("/aboutService/get")
    public ApiResponse getById(@RequestParam("id")Integer id){
        AboutServers aboutServiceById = aboutService.getById(id);
        if(aboutServiceById == null)
            return ApiResponseFactory.genFailApiResponse(" 不存在 该 服务");
        return ApiResponseFactory.genSuccessApiResponse(aboutServiceById);
    }
    @RequestMapping("/aboutService/getAllUseful")
    public ApiResponse getAllUseful(){
        List<AboutServers> allUseful = aboutService.getAllUseful();
        return ApiResponseFactory.genSuccessApiResponse(allUseful);
    }
}
