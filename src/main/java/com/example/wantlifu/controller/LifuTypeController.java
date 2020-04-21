package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.LifuTypeReciveEntity;
import com.example.wantlifu.entity.LifuType;
import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.service.impl.LifuTypeService;
import com.example.wantlifu.service.search.LifuTypeSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 礼服类型的 控制器
 *
 * @author want
 * @createTime 2020.02.24.23:03
 */
@RestController
public class LifuTypeController {

    @Autowired
    LifuTypeService lifuTypeService;

    /**
     * @param entity
     * @return
     */
    @PostMapping("admin/lifutype/select")
    public ApiResponse select(@RequestBody @Valid LifuTypeReciveEntity entity){

        PageInfo<LifuType> pageInfo= lifuTypeService.selectLifuType(entity);
        return ApiResponseFactory.genSuccessApiResponse(pageInfo);
    }
    @RequestMapping("lifutype/getUseful")
    public ApiResponse getUseful() {
        return  ApiResponseFactory.genSuccessApiResponse(lifuTypeService.selectAllUsefulTrademark());
    }

    @RequestMapping("admin/lifutype/update")
    public ApiResponse update(@RequestBody @Valid LifuType lifuType){
        Map<String, String> map = lifuTypeService.updateLifuType(lifuType);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @RequestMapping("admin/lifutype//add")
    public ApiResponse add(@RequestBody @Valid LifuType lifuType){
        Map<String, String> map = lifuTypeService.addLifuType(lifuType);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("admin/lifutype//ice")
    public ApiResponse icePriceAreaByIds(@RequestBody Integer[] ids){
        Map<String, String> map = lifuTypeService.iceLifuTypeByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("admin/lifutype//reback")
    public ApiResponse rebackPriceAreaByIds(@RequestBody Integer[] ids){
        Map<String, String> map = lifuTypeService.reBackLifuTypeByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }

}
