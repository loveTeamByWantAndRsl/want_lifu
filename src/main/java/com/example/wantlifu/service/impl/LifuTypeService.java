package com.example.wantlifu.service.impl;

import com.example.wantlifu.controller.reciveEntity.LifuTypeReciveEntity;
import com.example.wantlifu.dao.LifuTypeMapper;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.LifuType;
import com.example.wantlifu.entity.LifuTypeExample;
import com.example.wantlifu.exception.IceException;
import com.example.wantlifu.exception.IceOrBack;
import com.example.wantlifu.exception.ReBackException;
import com.example.wantlifu.service.search.LifuSearchEntity;
import com.example.wantlifu.service.search.LifuTypeSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 礼服 类型 服务层
 *
 * @author want
 * @createTime 2020.01.16.21:46
 */
@Service
public class LifuTypeService {
    @Autowired
    LifuTypeMapper lifuTypeMapper;

    /**
     * 增加 类型
     * @param lifuType
     * @return
     */
    public Map<String,String> addLifuType(LifuType lifuType){
        LifuTypeExample example = new LifuTypeExample();
        example.createCriteria().andNameEqualTo(lifuType.getName());
        List<LifuType> lifuTypes = lifuTypeMapper.selectByExample(example);
        if(lifuTypes.size() > 0)
            return StaticPool.genFailRes("该类型已存在！");
        int flag = lifuTypeMapper.insertSelective(lifuType);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 按需 查找 所有 类型
     * @param entity
     * @return
     */
    public PageInfo<LifuType> selectLifuType(LifuTypeReciveEntity entity){

        PageHelper.startPage(entity.getStart(),entity.getPageSize());
        LifuTypeExample example = new LifuTypeExample();
        LifuTypeExample.Criteria criteria = example.createCriteria();
        if(entity.getLifuTypeSearchEntity().getStatus() >= 0)
            criteria.andStatusEqualTo(entity.getLifuTypeSearchEntity().getStatus());
        if( !StringUtils.isEmpty(entity.getLifuTypeSearchEntity().getKey()))
            criteria.andNameLike(entity.getLifuTypeSearchEntity().getKey()+"%");
        List<LifuType> lifuTypes = lifuTypeMapper.selectByExample(example);

        return PageInfo.of(lifuTypes);
    }

    /**
     * 修改 类型
     * @param lifuType
     * @return
     */
    public Map<String,String> updateLifuType(LifuType lifuType){
        int flag = lifuTypeMapper.updateByPrimaryKeySelective(lifuType);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 删除 类型
     * @param id
     * @return
     */
    public Map<String,String> deleteLifuType(int id){
        LifuType lifuType = new LifuType();
        lifuType.setId(id);
        lifuType.setStatus(0);
        return this.updateLifuType(lifuType);
    }

    /**
     * 回复 类型
     * @param id
     * @return
     */
    public  Map<String,String> rebackLifuType(int id){
        LifuType lifuType = new LifuType();
        lifuType.setId(id);
        lifuType.setStatus(1);
        return this.updateLifuType(lifuType);
    }
    /**
     * 批量 恢复价格 区间 -- > 内部实现为循环调用 reBackPriceAreaById
     * @param ids
     * @return
     */
    public Map<String,String> reBackLifuTypeByIds(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = rebackLifuType(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new ReBackException(IceOrBack.LIFU_TYPE);
        }
        return StaticPool.genSuccessRes();
    }
    /**
     *
     * 批量删除 价格 区间 -- > 内部实现为循环调用 deletePriceAreaById
     * @param ids
     * @return
     */
    public Map<String,String> iceLifuTypeByIds(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = deleteLifuType(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new IceException(IceOrBack.LIFU_TYPE);
        }
        return StaticPool.genSuccessRes();
    }

    public List<LifuType> selectAllUsefulTrademark() {
        LifuTypeExample example = new LifuTypeExample();
        example.createCriteria().andStatusEqualTo(StaticPool.useful);
        return lifuTypeMapper.selectByExample(example);
    }
}
