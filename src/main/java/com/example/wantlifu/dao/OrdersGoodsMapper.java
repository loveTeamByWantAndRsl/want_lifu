package com.example.wantlifu.dao;

import com.example.wantlifu.entity.OrdersGoods;
import com.example.wantlifu.entity.OrdersGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersGoodsMapper {
    long countByExample(OrdersGoodsExample example);

    int deleteByExample(OrdersGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrdersGoods record);

    int insertSelective(OrdersGoods record);

    List<OrdersGoods> selectByExample(OrdersGoodsExample example);

    OrdersGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrdersGoods record, @Param("example") OrdersGoodsExample example);

    int updateByExample(@Param("record") OrdersGoods record, @Param("example") OrdersGoodsExample example);

    int updateByPrimaryKeySelective(OrdersGoods record);

    int updateByPrimaryKey(OrdersGoods record);
}