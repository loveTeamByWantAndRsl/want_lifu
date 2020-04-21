package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.LifuSku;
import com.example.wantlifu.service.impl.LifuSkuService;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.03.07.9:52
 */
@RestController
//@RequestMapping("admin/sku/")
public class SkuController {
    @Autowired
    LifuSkuService lifuSkuService;


    @RequestMapping("admin/sku/get/{id}")
    public ApiResponse selectByLifuId(@PathVariable Integer id){
        List<LifuSku> lifuSkus = lifuSkuService.selectSkuByLifuId(id);
        return ApiResponseFactory.genSuccessApiResponse(lifuSkus);
    }

    @PostMapping("admin/sku/add/{id}")
    public ApiResponse add(@PathVariable  Integer id, @RequestBody LifuSku lifuSku){
        lifuSku.setLifuId(id);
        Map<String, String> res;
        if(lifuSku.getId() == null || lifuSku.getId() <= 0)
            res = lifuSkuService.addSku(lifuSku);
        else
            res = lifuSkuService.updateSku(lifuSku);
        if(res.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(res.get(StaticPool.ERROR));
    }
    @GetMapping("/sku/list")
    public ApiResponse getList(@RequestParam("id") Integer id){
        List<LifuSku> lifuSkus = lifuSkuService.selectSkuByLifuId(id);
        HashSet<String> sizes = new HashSet<>();
        HashSet<String> colors = new HashSet<>();
        lifuSkus.forEach(l->{
            sizes.add(l.getSize());
            colors.add(l.getColor());
        });
        HashMap<String, HashSet<String>> map = new HashMap<>();
        map.put("sizes",sizes);
        map.put("colors",colors);
        return ApiResponseFactory.genSuccessApiResponse(map);
    }
//    @PostMapping("update/{id}")
//    public ApiResponse add(@PathVariable Integer id, @RequestBody LifuSku lifuSku){
//        lifuSku.setLifuId(id);
//        Map<String, String> res = lifuSkuService.addSku(lifuSku);
//        if(res.containsKey(StaticPool.SUCCESS))
//            return ApiResponseFactory.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
//        return ApiResponseFactory.genFailApiResponse(res.get(StaticPool.ERROR));
//    }


}
