package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.TrademarkMapper;
import com.example.wantlifu.entity.Trademark;
import com.example.wantlifu.entity.TrademarkExample;
import com.example.wantlifu.service.search.TrademarkSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.05.22:06
 *
 *
 * 礼服 品牌 的 服务层
 */
@Service
public class TrademarkService {


    TrademarkMapper trademarkMapper;

    /**
     * 分页 查询 品牌 --- 管理员使用
     * @param start
     * @param pageSize
     * @param entity
     * @return
     */
    public PageInfo<Trademark> selectTrademarkByTrademarkSearchEntity(Integer start, Integer pageSize, TrademarkSearchEntity entity){

        PageHelper.startPage(start,pageSize);
        TrademarkExample example = new TrademarkExample();
        TrademarkExample.Criteria criteria = example.createCriteria();

        if( !StringUtils.isEmpty(entity.getName()))
            criteria.andNameLike(entity.getName()+"%");
        if( entity.getStatus() != null && entity.getStatus() >= 0)
            criteria.andStatusEqualTo(entity.getStatus());
        if( !StringUtils.isEmpty(entity.getFirstChar() ) )
            criteria.andFirstcharEqualTo(entity.getFirstChar() );


        // ----------

        List<Trademark> trademarks = trademarkMapper.selectByExample(example);

        return PageInfo.of(trademarks);
    }


    /**
     * 查找 品牌按照 id
     * @param id
     * @return
     */
    public Trademark selectTrademarkById(int id){
        return trademarkMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改品牌
     * @param trademark
     * @return
     */
    public Map<String,String> updateTrademark(Trademark trademark){
        int flag = trademarkMapper.updateByPrimaryKeySelective(trademark);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 删除 品牌
     * @param id
     * @return
     */
    public Map<String,String> deleteTrademark(int id){
        Trademark trademark = new Trademark();
        trademark.setId(id);
        trademark.setStatus(StaticPool.notUseful);
        return this.updateTrademark(trademark);
    }
}
