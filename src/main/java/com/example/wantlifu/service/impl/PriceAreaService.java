package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.PriceAreaMapper;
import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.entity.PriceAreaExample;
import com.example.wantlifu.exception.IceException;
import com.example.wantlifu.exception.IceOrBack;
import com.example.wantlifu.exception.ReBackException;
import com.example.wantlifu.service.search.PriceAreaSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        example.createCriteria().andExpressEqualTo(priceArea.getExpress()).andTypeEqualTo(priceArea.getType());;
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
        if(priceArea.getId() == null)
            return StaticPool.genFailRes("Id为空！！错误");
        if( !StringUtils.isEmpty(priceArea.getExpress())){
            PriceAreaExample example = new PriceAreaExample();
            example.createCriteria().andExpressEqualTo(priceArea.getExpress()).andIdNotEqualTo(priceArea.getId()).andTypeEqualTo(priceArea.getType());
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
        PriceAreaExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        if(type != null && type >= 0)
            criteria.andTypeEqualTo(type);

        return priceAreaMapper.selectByExample(example);
    }
    /**
     * 按照 实体 进行查找
     * @param priceAreaSearchEntity
     * @return
     */
    public PageInfo<PriceArea> selectPriceAreaByPriceAreaSearchEntity(PriceAreaSearchEntity priceAreaSearchEntity,Integer start,Integer pageSize){
        PageHelper.startPage(start,pageSize);
        PriceAreaExample example = new PriceAreaExample();
        PriceAreaExample.Criteria criteria = example.createCriteria();
        if(priceAreaSearchEntity.getType() != null && priceAreaSearchEntity.getType() >=0)
            criteria.andTypeEqualTo(priceAreaSearchEntity.getType());
        if( !StringUtils.isEmpty(priceAreaSearchEntity.getExpress()))
            criteria.andExpressLike(priceAreaSearchEntity.getExpress()+"%");
        if( priceAreaSearchEntity.getMin() != null && priceAreaSearchEntity.getMin() >= 0)
            criteria.andMinGreaterThanOrEqualTo(priceAreaSearchEntity.getMin());
        if( priceAreaSearchEntity.getMax() != null && priceAreaSearchEntity.getMax() > 0)
            criteria.andMaxLessThanOrEqualTo(priceAreaSearchEntity.getMax());
        if( priceAreaSearchEntity.getStatus() != null && priceAreaSearchEntity.getStatus() >= 0)
            criteria.andStatusEqualTo(priceAreaSearchEntity.getStatus());

        return PageInfo.of(priceAreaMapper.selectByExample(example));
    }

    /**
     *根据 id 删除 价格 区间
     * @param id
     * @return
     */
    public Map<String,String> deletePriceAreaById(int id){
        PriceArea priceArea = new PriceArea();
        priceArea.setId(id);
        priceArea.setStatus(StaticPool.notUseful);
        return this.updatePriceArea(priceArea);
    }

    /**
     *
     * 批量删除 价格 区间 -- > 内部实现为循环调用 deletePriceAreaById
     * @param ids
     * @return
     */
    public Map<String,String> icePriceAreaByIds(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = deletePriceAreaById(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new IceException(IceOrBack.PRICE_AREA);
        }
        return StaticPool.genSuccessRes();
    }

    /**
     *恢复价格 区间
     * @param id
     * @return
     */
    public Map<String,String> reBackPriceAreaById(int id){
        PriceArea priceArea = new PriceArea();
        priceArea.setId(id);
        priceArea.setStatus(StaticPool.useful);
        return this.updatePriceArea(priceArea);
    }

    /**
     * 批量 恢复价格 区间 -- > 内部实现为循环调用 reBackPriceAreaById
     * @param ids
     * @return
     */
    public Map<String,String> reBackPriceAreaByIds(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = reBackPriceAreaById(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new ReBackException(IceOrBack.PRICE_AREA);
        }
        return StaticPool.genSuccessRes();
    }
}
