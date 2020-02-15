package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.WtOrderMapper;
import com.example.wantlifu.entity.WtOrder;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.10.15:11
 *
 *
 * 订单服务
 */
@Service
public class OrderService {

    @Autowired
    WtOrderMapper wtOrderMapper;


    /**
     * 增加订单
     */
    public Map<String,String> addOrder(WtOrder wtOrder){
        int flag = wtOrderMapper.insertSelective(wtOrder);

        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
}
