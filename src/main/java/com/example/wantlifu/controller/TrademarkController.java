package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.PriceAreaReciveEntity;
import com.example.wantlifu.controller.reciveEntity.TrademarkReciveEntity;
import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.entity.Trademark;
import com.example.wantlifu.service.impl.TrademarkService;
import com.example.wantlifu.util.StaticPool;
import com.example.wantlifu.util.redis.help.KeyUtil;
import com.example.wantlifu.util.redis.help.Start;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

/**
 *
 * 品牌的控制器
 * @author want
 * @createTime 2020.02.18.14:14
 *
 */
@RestController
@RequestMapping("/admin/trademark")
public class TrademarkController {

    @Autowired
    TrademarkService trademarkService;
    @Resource
    RedisTemplate<String,Integer> redisTemplate;

    @RequestMapping("getUseful")
    public ApiResponse getUseful() {
        return  ApiResponseFactory.genSuccessApiResponse(trademarkService.selectAllUsefulTrademark());
    }
    @RequestMapping("/select")
    public ApiResponse selectPriceAreaByEntity(@RequestBody @Valid TrademarkReciveEntity entity) {
        PageInfo<Trademark> priceAreaPageInfo = trademarkService
                .selectTrademarkByTrademarkSearchEntity(entity.getStart(),entity.getPageSize(),entity.getTrademarkSearchEntity());
        return  ApiResponseFactory.genSuccessApiResponse(StaticPool.SUCCESS,priceAreaPageInfo);
    }
    @PostMapping("add")
    public ApiResponse addTrademark(@RequestBody @Valid Trademark trademark){
        Map<String, String> map = trademarkService.addTrademark(trademark);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }

    @PostMapping("update")
    public ApiResponse updateTrademark(@RequestBody @Valid Trademark trademark){
        Map<String, String> map = trademarkService.updateTrademark(trademark);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }

    @PostMapping("ice")
    public ApiResponse delete(@RequestBody Integer[] ids){
        Map<String, String> map = trademarkService.deleteTrademarkByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("reback")
    public ApiResponse reBack(@RequestBody Integer[] ids){
        Map<String, String> map = trademarkService.reBackTrademarkByIds(ids);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    @PostMapping("love")
    public ApiResponse love(Integer tid,Integer uid){
        // redis 的 set

        String userKey = KeyUtil.genUserKey(uid);
        String userZsetKey = KeyUtil.genUserZSortKey(uid);
        String startKey = KeyUtil.genStartKey(Start.TRADEMARK,tid);


        SessionCallback<Object> sessionCallback = new SessionCallback<Object>(){
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                SetOperations set = operations.opsForSet();
                set.add(startKey,uid);
                set.add(userKey,tid);
                ZSetOperations zSet = operations.opsForZSet();
                zSet.add(userZsetKey,tid,zSet.size(userZsetKey));
                Object val=operations.exec();
                return val;
            }
        };
        Object execute = redisTemplate.execute(sessionCallback);
        if(execute == null)
            return ApiResponseFactory.genFailApiResponse("收藏失败 ， 请重试！");//map.get(StaticPool.ERROR)
        return ApiResponseFactory.genSuccessApiResponse("收藏成功！");
    }
    @PostMapping("unLove")
    public ApiResponse unLove(Integer tid,Integer uid){
        String userKey = KeyUtil.genUserKey(uid);
        String userZsetKey = KeyUtil.genUserZSortKey(uid);
        String startKey = KeyUtil.genStartKey(Start.TRADEMARK,tid);


        SessionCallback<Object> sessionCallback = new SessionCallback<Object>(){
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                SetOperations set = operations.opsForSet();
                set.remove(startKey,uid);
                set.remove(userKey,tid);
                ZSetOperations zSet = operations.opsForZSet();
                zSet.remove(userZsetKey,tid);
                Object val=operations.exec();
                return val;
            }
        };
        Object execute = redisTemplate.execute(sessionCallback);
        if(execute == null)
            return ApiResponseFactory.genFailApiResponse("取消收藏失败 ， 请重试！");//map.get(StaticPool.ERROR)
        return ApiResponseFactory.genSuccessApiResponse("取消收藏成功！");
    }

    @PostMapping("getMyLove")
    public ApiResponse getMyLove(Integer uid,Integer start,Integer pageSize){
        return ApiResponseFactory.genSuccessApiResponse(trademarkService.getMyLove(uid,start,pageSize));
    }
}
