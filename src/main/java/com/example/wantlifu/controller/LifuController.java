package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.LifuReciveEntity;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.service.impl.LifuService;
import com.example.wantlifu.service.search.LifuSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * lifu操作控制器
 *
 * @author want
 * @createTime 2020.02.15.15:20
 */
@RestController
public class LifuController {

    @Autowired
    LifuService lifuService;


    @RequestMapping("/index-lifu")
    public ApiResponse getIndexLifu(){
        /**
         * 首页轮播
         */
        List<Lifu> indexLunBoLifu = lifuService.getIndexLunBoLifu();
        //新品
        List<Lifu> newLifu = lifuService.indexNewLifu();
        //折扣
        List<Lifu> disCountLifu = lifuService.indexDisCountLifu();
        //热门
        List<Lifu> hotLifu = lifuService.indexHotLifu();
        //精选
        List<Lifu> bestLifu = lifuService.indexBestLifu();

        Map<String,List> map = new HashMap<>();
        map.put("indexLunBoLifu",indexLunBoLifu);
        map.put("newLifu",newLifu);
        map.put("disCountLifu",disCountLifu);
        map.put("hotLifu",hotLifu);
        map.put("bestLifu",bestLifu);
        return ApiResponseFactory.genSuccessApiResponse(map);
    }
    /**
     * 增加礼服，
     * 礼服必须要有 -- 品牌id
     * @param lifu
     * @return
     */
    @RequestMapping("admin/lifu/addLifu")
    public ApiResponse addLifu(@RequestBody @Valid Lifu lifu){
        if(lifu.getId() != null && lifu.getId() > 0)
            return updateLifu(lifu);
        Map<String, String> res = lifuService.addLifu(lifu);
        if(res.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse("success",res.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(res.get(StaticPool.ERROR));
    }

    /**
     * 查询礼服
     * @param lifuReciveEntity
     * @return
     */
    @RequestMapping("admin/lifu/select")
    public ApiResponse selectByEntity(@RequestBody @Valid LifuReciveEntity lifuReciveEntity){
        PageInfo<Lifu> lifuPageInfo = lifuService.queryLifuByEntity(lifuReciveEntity.getStart(), lifuReciveEntity.getPageSize(), lifuReciveEntity.getLifuSearchEntity());
        return ApiResponseFactory.genSuccessApiResponse("success",lifuPageInfo);
    }

    /**
     * 修改礼服
     */
    @RequestMapping("admin/lifu/update")
    public ApiResponse updateLifu(@RequestBody  @Valid Lifu lifu){
        Map<String,String> map = lifuService.updateLifu(lifu);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS),lifu.getId()+"");
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    /**
     * 下架礼服
     */
    @RequestMapping("admin/lifu/down/{id}")
    public ApiResponse down(@PathParam("id")int id){
        Map<String,String> map = lifuService.down(id);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    /**
     * 上架礼服
     */
    @RequestMapping("admin/lifu/up/{id}")
    public ApiResponse up(@PathParam("id")int id){
        Map<String,String> map = lifuService.up(id);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }

    /**
     * 下架礼服
     */
    @RequestMapping("admin/lifu/toIndex/{id}")
    public ApiResponse toIndex(@PathParam("id")Integer id){
        Map<String,String> map = lifuService.toIndex(id);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    /**
     * 上架礼服
     */
    @RequestMapping("admin/lifu/disIndex/{id}")
    public ApiResponse disIndex(@PathParam("id")Integer id){
        Map<String,String> map = lifuService.disIndex(id);
        if(map.containsKey(StaticPool.SUCCESS))
            return ApiResponseFactory.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        return ApiResponseFactory.genFailApiResponse(map.get(StaticPool.ERROR));
    }
    /**
     * 获取礼服
     */
    @RequestMapping("/lifu/get")
    public ApiResponse get(@RequestParam("id")Integer id){
        Lifu lifu = lifuService.getLifuById(id);
        return ApiResponseFactory.genSuccessApiResponse(lifu);
    }

    @RequestMapping("/lifu/show")
    public ApiResponse getShow(@RequestBody LifuReciveEntity lifuReciveEntity){
        PageInfo<Lifu> lifuPageInfo = lifuService.queryLifuByEntity(lifuReciveEntity.getStart()
                , lifuReciveEntity.getPageSize(), lifuReciveEntity.getLifuSearchEntity());
        return ApiResponseFactory.genSuccessApiResponse(lifuPageInfo);
    }
}
