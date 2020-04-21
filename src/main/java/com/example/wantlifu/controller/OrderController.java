package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.OrderReciveEntity;
import com.example.wantlifu.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 订单控制器
 *
 * @author want
 * @createTime 2020.02.25.20:49
 */
@RestController
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 查询所有订单
     * @param entity
     * @return
     */
    @PostMapping("select")
    public ApiResponse select(@RequestBody @Valid OrderReciveEntity entity){
        return ApiResponseFactory.genSuccessApiResponse(orderService.selectByEntity(entity));
    }

    /**
     * 查询退还订单
     * @param entity
     * @return
     */
    @PostMapping("selectReBack")
    public ApiResponse selectReBack(@RequestBody @Valid OrderReciveEntity entity){
        return ApiResponseFactory.genSuccessApiResponse(orderService.selectReBackOrder(entity));
    }

    /**
     * 查询 押金异议订单
     * @param entity
     * @return
     */
    @PostMapping("selectDifMeans")
    public ApiResponse selectDifMeans(@RequestBody @Valid OrderReciveEntity entity){
        return ApiResponseFactory.genSuccessApiResponse(orderService.selectDifMeansOrder(entity));
    }

    /**
     * 获取指定的订单
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ApiResponse get(@PathVariable("id") Integer id){
        return ApiResponseFactory.genSuccessApiResponse(orderService.selectById(id));
    }

}
