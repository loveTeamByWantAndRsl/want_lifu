package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.OrdersGoodsMapper;
import com.example.wantlifu.entity.OrdersGoods;
import com.example.wantlifu.entity.OrdersGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品详细 服务层
 *
 * @author want
 * @createTime 2020.01.16.22:28
 */
@Service
public class OrdersGoodsService {

    @Autowired
    OrdersGoodsMapper ordersGoodsMapper;
    /**
     * 增加
     * @param goods
     */

    public void addGoods(List<OrdersGoods> goods){
        goods.forEach(ordersGoods -> ordersGoodsMapper.insertSelective(ordersGoods));
    }
    /**
     * 查询
     */
    public List<OrdersGoods> selectByOrderId(int orderId){
        OrdersGoodsExample example = new OrdersGoodsExample();
        example.createCriteria().andOrderidEqualTo(orderId);
        List<OrdersGoods> ordersGoods = ordersGoodsMapper.selectByExample(example);
        return ordersGoods;
    }
}
