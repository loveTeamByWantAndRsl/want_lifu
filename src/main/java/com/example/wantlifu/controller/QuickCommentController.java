package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.QuickCommentReciveEntity;
import com.example.wantlifu.entity.QuickComment;
import com.example.wantlifu.service.impl.QuickCommentService;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Map;

/**
 * 快速回复的 控制器
 *
 * @author want
 * @createTime 2020.02.25.18:12
 */
@RestController
@RequestMapping("/admin/quickComment")
public class QuickCommentController {
    @Autowired
    QuickCommentService quickCommentService;


    /**
     * @param entity
     * @return
     */
    @PostMapping("/select")
    public ApiResponse select(@RequestBody @Valid QuickCommentReciveEntity entity){

        PageInfo<QuickComment> pageInfo= quickCommentService.selectByEntity(entity);
        return ApiResponseFactory.genSuccessApiResponse(pageInfo);
    }
    @GetMapping("get/{id}")
    public ApiResponse get(@PathVariable("id") Integer id){
        return ApiResponseFactory.genSuccessApiResponse(quickCommentService.get(id));
    }
    @RequestMapping("/update")
    public ApiResponse update(@RequestBody @Valid QuickComment quickComment){
        Map<String, String> map = quickCommentService.updateQuickComment(quickComment);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @RequestMapping("/add")
    public ApiResponse add(@RequestBody @Valid QuickComment quickComment){
        Map<String, String> map = quickCommentService.addQuickComment(quickComment);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("/ice")
    public ApiResponse icePriceAreaByIds(@RequestBody Integer[] ids){
        Map<String, String> map = quickCommentService.iceQuickComment(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("/reback")
    public ApiResponse rebackPriceAreaByIds(@RequestBody Integer[] ids){
        Map<String, String> map = quickCommentService.iceQuickComment(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
}
