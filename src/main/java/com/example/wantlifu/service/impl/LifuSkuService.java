package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.LifuSkuMapper;
import com.example.wantlifu.entity.LifuSku;
import com.example.wantlifu.entity.LifuSkuExample;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * lifu sku 服务层
 *
 *
 * @author want
 * @createTime 2020.01.16.21:39
 */
@Service
public class LifuSkuService {
    @Autowired
    LifuSkuMapper lifuSkuMapper;

    /**
     * 增加 sku
     * @param lifuSku
     * @return
     */
    public Map<String,String> addSku(LifuSku lifuSku){
        int flag = lifuSkuMapper.insertSelective(lifuSku);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 查找 sku
     * @param lifuId
     * @return
     */
    public List<LifuSku> selectSkuByLifuId(int lifuId){
        LifuSkuExample example = new LifuSkuExample();
        example.createCriteria().andLifuIdEqualTo(lifuId);
        return lifuSkuMapper.selectByExample(example);
    }

    /**
     * 查找 sku
     * @param id
     * @return
     */
    public LifuSku selectById(int id){
        return lifuSkuMapper.selectByPrimaryKey(id);
    }
    /**
     * 修改 sku
     * @param lifuSku
     * @return
     */
    public Map<String,String> updateSku(LifuSku lifuSku){
        int flag = lifuSkuMapper.updateByPrimaryKeySelective(lifuSku);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 删除 sku
     * @param id
     * @return
     */
    public Map<String,String> deleteById(int id){
        LifuSku lifuSku = new LifuSku();
        lifuSku.setId(id);
        lifuSku.setStatus(0);
        int flag = lifuSkuMapper.updateByPrimaryKeySelective(lifuSku);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

}
