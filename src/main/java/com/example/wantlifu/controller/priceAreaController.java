package com.example.wantlifu.controller;


import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.PriceAreaReciveEntity;
import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.service.impl.PriceAreaService;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.14.17:08
 *
 * 价格区间的控制器
 */
@RestController
public class priceAreaController {

    @Autowired
    PriceAreaService priceAreaService;


    @RequestMapping("/admin/priceArea/select")
    public ApiResponse selectPriceAreaByEntity(@RequestBody @Valid PriceAreaReciveEntity entity) {
        PageInfo<PriceArea> priceAreaPageInfo = priceAreaService.selectPriceAreaByPriceAreaSearchEntity(entity.getPriceAreaSearchEntity(),entity.getStart(),entity.getPageSize());
        return  ApiResponseFactory.genSuccessApiResponse(StaticPool.SUCCESS,priceAreaPageInfo);
    }

    @RequestMapping("/admin/priceArea/update")
    public ApiResponse update(@RequestBody @Valid PriceArea priceArea){
        Map<String, String> map = priceAreaService.updatePriceArea(priceArea);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @RequestMapping("/admin/priceArea/add")
    public ApiResponse add(@RequestBody @Valid PriceArea priceArea){
        Map<String, String> map = priceAreaService.addPriceArea(priceArea);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("/admin/priceArea/ice")
    public ApiResponse icePriceAreaByIds(@RequestBody Integer[] ids){
        Map<String, String> map = priceAreaService.icePriceAreaByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("/admin/priceArea/reback")
    public ApiResponse rebackPriceAreaByIds(@RequestBody Integer[] ids){
        Map<String, String> map = priceAreaService.reBackPriceAreaByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @RequestMapping("/priceArea/getPriceArea")
    public ApiResponse getPriceArea(@RequestParam("type")int type){
        List<PriceArea> priceAreas = priceAreaService.selectPriceAreaFormUserByType(type);
        return ApiResponseFactory.genSuccessApiResponse(priceAreas);
    }
}
