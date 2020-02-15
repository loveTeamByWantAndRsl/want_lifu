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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.14.17:08
 *
 * 价格区间的控制器
 */
@Controller
@RequestMapping("/admin/priceArea")
public class priceAreaController {

    @Autowired
    PriceAreaService priceAreaService;

    @ResponseBody
    @RequestMapping("/select")
    public ApiResponse selectPriceAreaByEntity(@RequestBody @Valid PriceAreaReciveEntity entity) {
//        if (jsonObject.get("start") == null || jsonObject.get("pageSize") == null
//                || jsonObject.get("status") == null || jsonObject.get("key") == null
//                || jsonObject.get("min") == null || jsonObject.get("max") == null
//                || jsonObject.get("type") == null)
//            return ApiResponseFactory.genFailApiResponse("参数 错误 ！");
//        Integer start = Integer.valueOf(jsonObject.get("start").toString());
//        Integer status = Integer.valueOf(jsonObject.get("status").toString());
//        Integer pageSize = Integer.valueOf(jsonObject.get("pageSize").toString());
//        String key = jsonObject.get("key").toString();
//        Integer min = Integer.valueOf(jsonObject.get("min").toString());
//        Integer max = Integer.valueOf(jsonObject.get("max").toString());
//        Integer type = Integer.valueOf(jsonObject.get("type").toString());

        PageInfo<PriceArea> priceAreaPageInfo = priceAreaService.selectPriceAreaByPriceAreaSearchEntity(entity.getPriceAreaSearchEntity(),entity.getStart(),entity.getPageSize());
        return  ApiResponseFactory.genSuccessApiResponse(StaticPool.SUCCESS,priceAreaPageInfo);
    }

    @PostMapping("/add")
    public ApiResponse add(PriceArea priceArea){
        Map<String, String> map = priceAreaService.addPriceArea(priceArea);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
}
