package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.LifuTypeMapper;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.LifuType;
import com.example.wantlifu.entity.LifuTypeExample;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param status
     * @return
     */
    public List<LifuType> selectLifuType(int status){
        LifuTypeExample example = new LifuTypeExample();
        if(status >= 0){
            example.createCriteria().andStatusEqualTo(status);
        }
        return lifuTypeMapper.selectByExample(example);
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
}
