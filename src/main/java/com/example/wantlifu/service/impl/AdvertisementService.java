package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.AdvertisingMapper;
import com.example.wantlifu.entity.Advertising;
import com.example.wantlifu.entity.AdvertisingExample;
import com.example.wantlifu.service.search.AdvertSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 广告 服务层
 *
 * @author want
 * @createTime 2020.01.08.20:39
 */
@Service
public class AdvertisementService {
    @Autowired
    AdvertisingMapper advertisingMapper;

    /**
     * 增加 广告
     * @param advertising
     * @return
     */
    public Map<String,String> addAdvert(Advertising advertising){
        int flag = advertisingMapper.insertSelective(advertising);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 为广告 增加时间
     * @param time
     * @param timeUnit
     * @param id
     * @return
     */
    public Map<String,String> addAdvertTime(int time, TimeUnit timeUnit,int id){
        Advertising advertising = advertisingMapper.selectByPrimaryKey(id);
        if(advertising == null)
            return StaticPool.genFailRes("id 不合法");

        LocalDateTime time2 = StaticPool.dateToLocalDateTime(advertising.getEndTime());


        switch (timeUnit){
            case SECONDS:
                advertising.setEndTime(StaticPool.localDateTimeToDate(time2.plus(time,ChronoUnit.SECONDS)));
                break;
            case MINUTES:
                advertising.setEndTime(StaticPool.localDateTimeToDate(time2.plus(time, ChronoUnit.MINUTES)));
                break;
            case HOURS:
                advertising.setEndTime(StaticPool.localDateTimeToDate(time2.plus(time, ChronoUnit.HOURS)));
                break;
            case DAYS:
                advertising.setEndTime(StaticPool.localDateTimeToDate(time2.plus(time, ChronoUnit.DAYS)));
                break;
            default:
                return StaticPool.genFailRes("时间参数 不合法");
        }
        int flag = advertisingMapper.insertSelective(advertising);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 删除 广告
     * @param id
     * @return
     */
    public Map<String,String> deleteAdvert(int id){
        Advertising advertising = advertisingMapper.selectByPrimaryKey(id);
        if(advertising == null)
            return StaticPool.genFailRes("id 不合法");
        advertising.setStatus(0);
        int flag = advertisingMapper.insertSelective(advertising);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 修改 广告
     * @param advertising
     * @return
     */
    public Map<String,String> updateAdvert(Advertising advertising){
        Advertising advertising1 = advertisingMapper.selectByPrimaryKey(advertising.getId());
        if(advertising1 == null)
            return StaticPool.genFailRes("id 不合法");
        int flag = advertisingMapper.updateByPrimaryKeySelective(advertising);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
    //查询广告

    /**
     * 分页查询 广告
     * @param start
     * @param size
     * @param entity
     * @return
     */
    public PageInfo<Advertising> selectAdvert(int start, int size, AdvertSearchEntity entity){
        AdvertisingExample example = new AdvertisingExample();
        AdvertisingExample.Criteria criteria = example.createCriteria();
        PageHelper.startPage(start,size);
        //关键字
        if(!StringUtils.isEmpty(entity.getKey())){
            criteria.andTitleLike(entity.getKey()+"%");
        }
        if(entity.getStartTime() != null)
            criteria.andStartTimeGreaterThan(StaticPool.localDateTimeToDate(entity.getStartTime()));
        if(entity.getEndTime() != null)
            criteria.andEndTimeLessThan(StaticPool.localDateTimeToDate(entity.getEndTime()));
        example.setOrderByClause(entity.getOrderByKey()+entity.getOrderType());
        List<Advertising> advertisings = advertisingMapper.selectByExample(example);

        return PageInfo.of(advertisings);
    }

    /**
     * 查找 广告 按id
     * @param id
     * @return
     */
    public Advertising selectAdvertById(int id){
        return advertisingMapper.selectByPrimaryKey(id);
    }


    /**
     * 删除 广告
     * @param ids
     * @return
     */
    public Map<String,String> deleteAdvert(List<Integer> ids){
//        Advertising advertising = advertisingMapper.selectByPrimaryKey(id);
//        if(advertising == null)
//            return StaticPool.genFailRes("id 不合法");
//        advertising.setStatus(0);
//        int flag = advertisingMapper.insertSelective(advertising);
//        if(flag > 0)
//            return StaticPool.genSuccessRes();
//        return StaticPool.genFailRes();
        Advertising advertising = new Advertising();
        advertising.setStatus(0);
        AdvertisingExample example = new AdvertisingExample();
        example.createCriteria().andIdIn(ids);
        int flag = advertisingMapper.updateByExampleSelective(advertising, example);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
}
