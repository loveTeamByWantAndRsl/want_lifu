package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.PriceAreaMapper;
import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.entity.PriceAreaExample;
import com.example.wantlifu.service.search.PriceAreaSearchEntity;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.05.19:29
 *
 * 价格区间 的 服务层
 *
 */
@Service
public class PriceAreaService {

    @Autowired
    PriceAreaMapper priceAreaMapper;

    /**
     * 增加 价格 区间
     * @param priceArea
     * @return
     */
    public Map<String,String> addPriceArea(PriceArea priceArea){
        PriceAreaExample example = new PriceAreaExample();
        example.createCriteria().andExpressEqualTo(priceArea.getExpress());
        List<PriceArea> priceAreas = priceAreaMapper.selectByExample(example);

        if( !priceAreas.isEmpty())
            return StaticPool.genFailRes("该价格区间已存在！");

        int flag = priceAreaMapper.insertSelective(priceArea);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 修改 价格 区间
     * @param priceArea
     * @return
     */
    public Map<String,String> updatePriceArea(PriceArea priceArea){
        if( !StringUtils.isEmpty(priceArea.getExpress())){
            PriceAreaExample example = new PriceAreaExample();
            example.createCriteria().andExpressEqualTo(priceArea.getExpress()).andIdEqualTo(priceArea.getId());
            List<PriceArea> priceAreas = priceAreaMapper.selectByExample(example);

            if( !priceAreas.isEmpty())
                return StaticPool.genFailRes("该价格区间已存在！");
        }

        int flag = priceAreaMapper.updateByPrimaryKeySelective(priceArea);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 用户 查看的 价格区间
     * @param type
     * @return
     */
    public List<PriceArea> selectPriceAreaFormUserByType(Integer type){
        PriceAreaExample example = new PriceAreaExample();
        example.createCriteria().andTypeEqualTo(type).andStatusEqualTo(1);

        return priceAreaMapper.selectByExample(example);
    }
    /**
     * 按照 实体 进行查找
     * @param priceAreaSearchEntity
     * @return
     */
    public List<PriceArea> selectPriceAreaByPriceAreaSearchEntity(PriceAreaSearchEntity priceAreaSearchEntity){
        PriceAreaExample example = new PriceAreaExample();
        PriceAreaExample.Criteria criteria = example.createCriteria();
        if( !StringUtils.isEmpty(priceAreaSearchEntity.getExpress()))
            criteria.andExpressLike(priceAreaSearchEntity.getExpress()+"%");
        if( priceAreaSearchEntity.getMin() != null && priceAreaSearchEntity.getMin() >= 0)
            criteria.andMinGreaterThanOrEqualTo(priceAreaSearchEntity.getMin());
        if( priceAreaSearchEntity.getMax() != null && priceAreaSearchEntity.getMax() > 0)
            criteria.andMaxLessThanOrEqualTo(priceAreaSearchEntity.getMax());
        if( priceAreaSearchEntity.getStatus() != null && priceAreaSearchEntity.getStatus() >= 0)
            criteria.andStatusEqualTo(priceAreaSearchEntity.getStatus());

        return priceAreaMapper.selectByExample(example);
    }

    /**
     *删除 价格 区间
     * @param id
     * @return
     */
    public Map<String,String> deletePriceArea(int id){
        PriceArea priceArea = new PriceArea();
        priceArea.setId(id);
        priceArea.setStatus(0);
        return this.updatePriceArea(priceArea);
    }
}
