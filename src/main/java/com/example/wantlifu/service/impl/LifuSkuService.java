package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.LifuSkuMapper;
import com.example.wantlifu.entity.LifuSku;
import com.example.wantlifu.entity.LifuSkuExample;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    LifuService lifuService;

    /**
     * 增加 sku
     * @param lifuSku
     * @return
     */
    public Map<String,String> addSku(LifuSku lifuSku){
        int flag = lifuSkuMapper.insertSelective(lifuSku);
        if(flag > 0){
            Map<String, String> res = lifuService.updateLifuCount(lifuSku.getLifuId(), lifuSku.getCount());
            if(res.containsKey(StaticPool.SUCCESS))
                return StaticPool.genSuccessRes(lifuSku.getId()+"");
            return res;
        }
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
     * 删除 sku 根据 id
     * @param id
     * @return
     */
    public Map<String,String> deleteById(int id){
        LifuSku lifuSku = new LifuSku();
        lifuSku.setId(id);
        lifuSku.setStatus(StaticPool.notUseful);
        int flag = lifuSkuMapper.updateByPrimaryKeySelective(lifuSku);

        LifuSku lifuSku1 = lifuSkuMapper.selectByPrimaryKey(id);

        if(flag > 0)
            return lifuService.updateLifuCount(lifuSku.getLifuId(), lifuSku1.getCount());
        return StaticPool.genFailRes();
    }

    /**
     * 删除 sku 根据 礼服id
     *
     * @param lid
     * @return
     */
    public Map<String,String> deleteByLifuId(int lid){
        LifuSkuExample example = new LifuSkuExample();
        example.createCriteria().andLifuIdEqualTo(lid);
        LifuSku lifuSku = new LifuSku();
        lifuSku.setStatus(StaticPool.notUseful);
        int flag = lifuSkuMapper.updateByExampleSelective(lifuSku, example);
        if(flag > 0 )
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 获取 商品 sku的count
     * @param ids
     * @return
     */
    public List<Integer> selectSKUCountBySKUIds(List<Integer> ids){
        LifuSkuExample example = new LifuSkuExample();
        example.createCriteria().andIdIn(ids);
        List<LifuSku> lifuSkus = lifuSkuMapper.selectByExample(example);
        List<Integer> counts = lifuSkus.stream().map(sku -> sku.getCount()).collect(Collectors.toList());
        return counts;
    }

}
