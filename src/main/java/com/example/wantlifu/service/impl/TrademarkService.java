package com.example.wantlifu.service.impl;

import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.dao.LifuMapper;
import com.example.wantlifu.dao.TrademarkMapper;
import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.LifuExample;
import com.example.wantlifu.entity.Trademark;
import com.example.wantlifu.entity.TrademarkExample;
import com.example.wantlifu.exception.TrademarkNotExistsException;
import com.example.wantlifu.service.search.TrademarkSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.example.wantlifu.util.redis.help.KeyUtil;
import com.example.wantlifu.util.redis.help.Start;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author want
 * @createTime 2020.02.05.22:06
 *
 *
 * 礼服 品牌 的 服务层
 */
@Service
public class TrademarkService {

    @Autowired
    TrademarkMapper trademarkMapper;
    @Autowired
    LifuMapper lifuMapper;
    @Resource
    RedisTemplate<String,Integer> redisTemplate;

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

        //获取 喜爱 数量
        trademarks.stream().forEach(t -> {
            String key = KeyUtil.genStartKey(Start.TRADEMARK, t.getId());
            Long size = redisTemplate.opsForSet().size(key);
            t.setLovecount(size.intValue());
        });

        return PageInfo.of(trademarks);
    }


    /**
     * 查找 品牌按照 id
     * @param id
     * @return
     */
    public Trademark selectTrademarkById(Integer id){
        return trademarkMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改品牌
     * @param trademark
     * @return
     */
    public Map<String,String> updateTrademark(Trademark trademark){
        if(trademark.getId() == null)
            return StaticPool.genFailRes("id 错误！");
        int flag = trademarkMapper.updateByPrimaryKeySelective(trademark);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        if(trademarkMapper.selectByPrimaryKey(trademark.getId()) == null)
            return StaticPool.genFailRes("id 不存在！");
        return StaticPool.genFailRes();
    }



    /**
     * 删除 品牌
     * @param id
     * @return
     */
    public Map<String,String> deleteTrademark(Integer id){
        Trademark trademark = new Trademark();
        trademark.setId(id);
        trademark.setStatus(StaticPool.notUseful);
        return this.updateTrademark(trademark);
        //继续 删除 其品牌下的 礼服！！！
    }
    /**
     * 删除 品牌
     * @param ids
     * @return
     */
    public Map<String,String> deleteTrademarkByIds(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = deleteTrademark(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new RuntimeException(StaticPool.ERROR);
        }
        return StaticPool.genSuccessRes();
    }

    /**
     * 恢复 品牌
     * @param id
     * @return
     */
    public Map<String,String> reBackTrademarkById(Integer id){
        Trademark trademark = new Trademark();
        trademark.setId(id);
        trademark.setStatus(StaticPool.useful);
        return this.updateTrademark(trademark);
    }
    /**
     * 恢复 品牌
     * @param ids
     * @return
     */
    public Map<String,String> reBackTrademarkByIds(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = reBackTrademarkById(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new RuntimeException(StaticPool.ERROR);
        }
        return StaticPool.genSuccessRes();
    }
    /**
     * 增加 品牌
     * @param trademark
     * @return
     */
    public Map<String,String> addTrademark(Trademark trademark){
        int flag = trademarkMapper.insertSelective(trademark);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 获取 关注 状态
     * @param tid
     * @param uid
     * @return
     */
    public Map<Integer,Boolean> getStatus(Set<Integer> tid, Integer uid){
        String userKey = KeyUtil.genUserKey(uid);
        SetOperations<String, Integer> set = redisTemplate.opsForSet();
        HashMap<Integer,Boolean> res = new HashMap<>();
        for (Integer id : tid)
            res.put(id,set.isMember(userKey,id));

        return res;
    }
    /**
     * 获取喜欢的 trademark
     * @param
     * @param uid
     * @return
     */
    public PageInfo<Trademark> getMyLove(Integer uid,Integer start,Integer pageSize){

        String userKey = KeyUtil.genUserKey(uid);
        Set<Integer> integers = redisTemplate.opsForSet().members(userKey);
        TrademarkExample example = new TrademarkExample();

        ArrayList<Integer> list = new ArrayList<>(integers);
        PageHelper.startPage(start,pageSize);
        example.createCriteria().andIdIn(list);
        List<Trademark> trademarks = trademarkMapper.selectByExample(example);

        return PageInfo.of(trademarks);
    }

    /**
     * 查找所有的 trademark
     * @return
     */
    public List<Trademark> selectAllUsefulTrademark() {
        TrademarkExample example = new TrademarkExample();
        example.createCriteria().andStatusEqualTo(StaticPool.useful);
        return  trademarkMapper.selectByExample(example);
    }

    /**
     * 修改 品牌下 的 礼服的 数量
     * @param id
     * @param count
     * @return
     */
    public Map<String,String> updateTradeMarkCount(int id,int count){
        Trademark trademark = trademarkMapper.selectByPrimaryKey(id);
        if( trademark == null )
            throw new TrademarkNotExistsException();
        trademark.setCommentcount(count+(trademark.getLifucount() == null ? 0 : trademark.getLifucount()));
        int flag = trademarkMapper.insertSelective(trademark);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes("服务繁忙");
    }
    /**
     * 增加 品牌下 的 礼服的 数量
     */
    public Map<String,String> incTradeMarkCount(int id,int count){
        return updateTradeMarkCount(id,count);
    }
    /**
     * 减少 品牌下 的 礼服的 数量
     */
    public Map<String,String> decTradeMarkCount(int id,int count){
        return updateTradeMarkCount(id,0-count);
    }
}
