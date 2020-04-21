package com.example.wantlifu.service.impl;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.controller.reciveEntity.OrderEntity;
import com.example.wantlifu.controller.reciveEntity.PayEntity;
import com.example.wantlifu.dao.LifuMapper;
import com.example.wantlifu.dao.LifuSkuMapper;
import com.example.wantlifu.dao.TrademarkMapper;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.LifuExample;
import com.example.wantlifu.entity.OrdersGoods;
import com.example.wantlifu.entity.Trademark;
import com.example.wantlifu.exception.LifuNotExistsException;
import com.example.wantlifu.service.search.LifuSearchEntity;
import com.example.wantlifu.service.search.RentValueBlock;
import com.example.wantlifu.service.search.TrademarkSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.security.auth.Subject;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 礼服 服务层
 *
 * @author want
 * @createTime 2020.01.08.20:37
 */
@Service
@CacheConfig(cacheNames="lifu")
public class LifuService {

    @Autowired
    LifuMapper lifuMapper;
    @Autowired
    LifuSkuMapper lifuSkuMapper;
    @Autowired
    RentValueBlock rentValueBlock;
    @Autowired
    TrademarkService trademarkService;

    /**
     * 首页 新品礼服
     * @return
     */
    @Cacheable(key = "'indexNewLifu'")
    public List<Lifu> indexNewLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setIsNew(StaticPool.useful);

        return queryLifuByEntity(0,8,entity).getList();
    }

    /**
     * 首页 特惠礼服
     * @return
     */
    @Cacheable(key = "'indexDisCountLifu'")
    public List<Lifu> indexDisCountLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setDiscount(StaticPool.useful);

        return queryLifuByEntity(0,8,entity).getList();
    }

    /**
     * 首页 轮播图礼服
     * @return
     */
    @Cacheable(key = "'getIndexLunBoLifu'")
    public List<Lifu> getIndexLunBoLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setShowInIndex(StaticPool.useful);

        return queryLifuByEntity(0,8,entity).getList();
    }
    /**
     * 首页 热门礼服
     * @return
     */
    @Cacheable(key = "'indexHotLifu'")
    public List<Lifu> indexHotLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setIsHot(StaticPool.useful);

        return queryLifuByEntity(0,8,entity).getList();
    }
    /**
     * 首页 精选礼服
     * @return
     */
    @Cacheable(key = "'indexBestLifu'")
    public List<Lifu> indexBestLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setOrderByKey("true_price ");
        entity.setOrderType("desc");

        return queryLifuByEntity(0,8,entity).getList();
    }

    /**
     * 搜索 礼服
     * @param start
     * @param pageSize
     * @param entity
     * @return
     */
    public PageInfo<Lifu> queryLifuByEntity(Integer start, Integer pageSize, LifuSearchEntity entity){

        PageHelper.startPage(start,pageSize);


        LifuExample example = new LifuExample();
        LifuExample.Criteria criteria = example.createCriteria();
        //关键字
        if(!StringUtils.isEmpty(entity.getKeyWord())){
            criteria.andNameLike(entity.getKeyWord()+"%");
        }
        //首页展示
        if(entity.getShowInIndex() >= 0)
            criteria.andShowInIndexEqualTo(entity.getShowInIndex());
        //分类
        if(entity.getLifuType() > 0)
            criteria.andTypeIdEqualTo(entity.getLifuType());
        //折扣
        if(entity.getDiscount() >= 0)
            criteria.andDiscountEqualTo(entity.getDiscount());
        //订制 还是 租聘
        if(entity.getBigType() >= 0)
            criteria.andCanZuPinEqualTo(entity.getBigType());
        //新品
        if(entity.getIsNew() >= 0)
            criteria.andIsNewEqualTo(entity.getIsNew());
        //热销
        if(entity.getIsHot() >= 0)
            criteria.andIsHotEqualTo(entity.getIsHot());
        //品牌
        if(entity.getType() > 0)
            criteria.andTrademarkIdEqualTo(entity.getType());
        //价格区间 筛选
        RentValueBlock rentValueBlock = this.rentValueBlock.getRentValueBlock(entity.getBigType(), entity.getPriceArea());
        if(rentValueBlock.getMin() > 0)
            criteria.andTruePriceGreaterThanOrEqualTo(rentValueBlock.getMin().floatValue());
        if(rentValueBlock.getMax() > 0)
            criteria.andTruePriceLessThanOrEqualTo(rentValueBlock.getMax().floatValue());
        //状态
        if(entity.getStatus() >= 0)
            criteria.andStatusEqualTo(entity.getStatus());
        example.setOrderByClause(entity.getOrderByKey()+entity.getOrderType());

        List<Lifu> lifus = lifuMapper.selectByExample(example);
        PageInfo<Lifu> lifuPageInfo = PageInfo.of(lifus);
        return lifuPageInfo;
    }

    /**
     * 增加礼服
     * @param lifu
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String,String> addLifu(Lifu lifu){
        lifu.setCreateTime(new Date());
        int flag = lifuMapper.insertSelective(lifu);
        if(flag > 0){
            Map<String, String> res = trademarkService.incTradeMarkCount(lifu.getTrademarkId(), 1);
            if(res.containsKey(StaticPool.SUCCESS))
                return StaticPool.genSuccessRes(lifu.getId()+"");
            return res;
        }
        return StaticPool.genFailRes("服务繁忙");
    }

    /**
     * 修改礼服
     * @param lifu
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String,String> updateLifu(Lifu lifu){
        if(lifu.getId() != null && lifu.getId() > 0){
            Lifu lifu1 = lifuMapper.selectByPrimaryKey(lifu.getId());

            //涉及 品牌 修改
            if( !lifu1.getId().equals(lifu.getId())) {
                //涉及状态修改
                if (lifu1.getStatus() == StaticPool.useful) {
                    Map<String, String> stringStringMap1 = trademarkService.decTradeMarkCount(lifu1.getTrademarkId(), 1);
                    if (stringStringMap1.containsKey(StaticPool.ERROR))
                        return stringStringMap1;
                }
                if( lifu.getStatus() == StaticPool.useful ){
                    Map<String, String> stringStringMap1 = trademarkService.incTradeMarkCount(lifu.getTrademarkId(), 1);
                    if (stringStringMap1.containsKey(StaticPool.ERROR))
                        return stringStringMap1;
                }
            }
            int flag = lifuMapper.updateByPrimaryKeySelective(lifu);
            if(flag > 0)
                return StaticPool.genSuccessRes();
            return StaticPool.genFailRes();
        }
        return StaticPool.genFailRes("参数错误 ！ 礼服id不合法！");
    }

    /**
     * 下架礼服 -- 使用 updateLifu 的方法下架礼服
     * @param id
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String,String> down(int id){
        if(id <= 0)
            return StaticPool.genFailRes("id不合法！！！");
        Lifu lifu = new Lifu();
        lifu.setId(id);
        lifu.setStatus(StaticPool.notUseful);
        return updateLifu(lifu);
    }
    /**
     * 上架礼服 -- 使用 updateLifu 的方法下架礼服
     * @param id
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String,String> up(int id){
        if(id <= 0)
            return StaticPool.genFailRes("id不合法！！！");
        Lifu lifu = new Lifu();
        lifu.setId(id);
        lifu.setStatus(StaticPool.useful);
        return updateLifu(lifu);
    }

    /**
     * 增加数量
     * @param lid
     * @param count
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String,String> updateLifuCount(int lid,Integer count){
        if(count == null)
            return StaticPool.genFailRes();
        Lifu lifu = lifuMapper.selectByPrimaryKey(lid);
        if(lifu == null){
            throw new LifuNotExistsException();
        }
        Integer count1 = lifu.getCount();
        Integer count2 = ( count1 == null ? count : count1 + count );

        Lifu lifu1 = new Lifu();
        lifu1.setId(lid);
        lifu.setCount(count2);

        return updateLifu(lifu);
    }
    /**
     * 删除 品牌 下的 礼服
     *
     * @param tid
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String,String> updateLifuByTardemarkDeleted(int tid){
        Lifu lifu = new Lifu();
        lifu.setStatus(StaticPool.notUseful);
        LifuExample example = new LifuExample();
        example.createCriteria().andTrademarkIdEqualTo(tid);
        int flag = lifuMapper.updateByExampleSelective(lifu, example);
        if(flag > 0){
            // 发送删除 礼服 下 sku 的 信息
            return StaticPool.genSuccessRes();
        }
        return StaticPool.genFailRes();
    }


    /**
     * 首页轮播图移除
     * @param id
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String, String> disIndex(int id) {
        if(id <= 0)
            return StaticPool.genFailRes("id不合法！！！");
        Lifu lifu = new Lifu();
        lifu.setId(id);
        lifu.setShowInIndex(StaticPool.notUseful);
        return updateLifu(lifu);
    }

    /**
     * 首页轮播图添加
     * @param id
     * @return
     */
    @CacheEvict(allEntries=true)
    public Map<String, String> toIndex(int id) {
        if(id <= 0)
            return StaticPool.genFailRes("id不合法！！！");
        Lifu lifu = new Lifu();
        lifu.setId(id);
        lifu.setShowInIndex(StaticPool.useful);
        return updateLifu(lifu);
    }

    public Lifu getLifuById(int id){
        return lifuMapper.selectByPrimaryKey(id);
    }

    public OrderEntity setCountAndValidaCount(PayEntity payEntity) {

        LifuExample example = new LifuExample();
        Map<Integer, PayEntity.SonEntity> idAndCountMap = Stream.of(payEntity.getSonEntity())
                .collect(Collectors
                        .toMap(PayEntity.SonEntity::getId, sonEntity ->  sonEntity, (key1, key2) -> key1));

        example.createCriteria().andIdIn(new ArrayList<>(idAndCountMap.keySet()));
        List<Lifu> lifus = lifuMapper.selectByExample(example);

        if( lifus.size() < payEntity.getSonEntity().length)
            throw new RuntimeException(" have no match lifu !");

        List<OrdersGoods> goods = new ArrayList<>(lifus.size());



        for(Lifu l :  lifus){
            PayEntity.SonEntity son =  idAndCountMap.get(l.getId());
            int rCount = l.getCount() - son.getCount();
            if(rCount < 0)
                return null;
            goods.add(new OrdersGoods(l,son.getCount(),son.getSize(),son.getColor()));
            l.setCount(rCount);
            l.setBuyCount(l.getBuyCount()+1);
        }

        for(Lifu l :  lifus) {
            int flag = lifuMapper.updateByPrimaryKeySelective(l);
            if(flag == 0)
                return null;
        }

        OrderEntity entity = new OrderEntity();

        StringBuilder sb = new StringBuilder();
        StringBuilder sbforSubject = new StringBuilder();
        Double price = 0.0;
        for ( Lifu l : lifus) {
            String c = l.getName();
            sb.append(c).append("--");
            sbforSubject.append(c.substring(0,Math.min(5,c.length()))).append("---");
            price += l.getTruePrice() * idAndCountMap.get(l.getId()).getCount();
        }
        entity.setBody(sb.toString());
        entity.setSubject(sbforSubject.toString());
        entity.setTotal_amount(price);
        entity.setGoods(goods);

        return entity;
    }
}
