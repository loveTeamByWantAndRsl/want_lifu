package com.example.wantlifu.service.impl;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.dao.LifuMapper;
import com.example.wantlifu.dao.LifuSkuMapper;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.LifuExample;
import com.example.wantlifu.service.search.LifuSearchEntity;
import com.example.wantlifu.service.search.RentValueBlock;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 礼服 服务层
 *
 * @author want
 * @createTime 2020.01.08.20:37
 */
@Service
public class LifuService {

    @Autowired
    LifuMapper lifuMapper;
    @Autowired
    LifuSkuMapper lifuSkuMapper;
    @Autowired
    RentValueBlock rentValueBlock;

    /**
     * 首页 新品礼服
     * @return
     */
    public List<Lifu> indexNewLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setIsNew(1);

        return queryLifuByEntity(0,8,entity).getList();
    }

    /**
     * 首页 特惠礼服
     * @return
     */
    public List<Lifu> indexDisCountLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setDiscount(1);

        return queryLifuByEntity(0,8,entity).getList();
    }
    /**
     * 首页 热门礼服
     * @return
     */
    public List<Lifu> indexHotLifu(){
        LifuSearchEntity entity = new LifuSearchEntity();
        entity.setIsHot(1);

        return queryLifuByEntity(0,8,entity).getList();
    }
    /**
     * 首页 精选礼服
     * @return
     */
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
        //分类
        if(entity.getLifuType() >= 0)
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
        if(entity.getType() >= 0)
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

    public Map<String,String> addLifu(Lifu lifu){
        int flag = lifuMapper.insertSelective(lifu);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
}
