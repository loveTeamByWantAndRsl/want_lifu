package com.example.wantlifu.service.impl;

import com.example.wantlifu.controller.reciveEntity.OrderReciveEntity;
import com.example.wantlifu.dao.WtOrderMapper;
import com.example.wantlifu.entity.OrdersGoods;
import com.example.wantlifu.entity.WtOrder;
import com.example.wantlifu.entity.WtOrderExample;
import com.example.wantlifu.service.search.OrderSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.example.wantlifu.util.order.help.OrderStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    OrdersGoodsService ordersGoodsService;


    /**
     * 增加订单
     */
    public Map<String,String> addOrder(WtOrder wtOrder){
        wtOrder.setCreatedTime(new Date());
        int flag = wtOrderMapper.insertSelective(wtOrder);

        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 查询订单
     * @param entity
     * @return
     */
    public PageInfo<WtOrder> selectByEntity(OrderReciveEntity entity){
        WtOrderExample example = new WtOrderExample();
        WtOrderExample.Criteria criteria = example.createCriteria();

        OrderSearchEntity oSEntity = entity.getEntity();

        PageHelper.startPage(entity.getStart(),entity.getPageSize());

        //支付流水号
        if( !StringUtils.isEmpty(oSEntity.getTradeNo()))
            criteria.andTradeNoEqualTo(oSEntity.getTradeNo());
        //订单号
        if( !StringUtils.isEmpty(oSEntity.getOrderNo()))
            criteria.andOrderNoEqualTo(oSEntity.getOrderNo());
        //用户id
        if( oSEntity.getUserId() != null && oSEntity.getUserId() > 0)
            criteria.andUseridEqualTo(oSEntity.getUserId());
        //username
        if( !StringUtils.isEmpty(oSEntity.getUserName()))
            criteria.andUserNameEqualTo(oSEntity.getUserName());
        //订单状态
        if( oSEntity.getStatus() != null && oSEntity.getStatus() >= 0)
            criteria.andStatusEqualTo(oSEntity.getStatus());
        //是否支付
        if( oSEntity.getIsPay() != null && oSEntity.getIsPay() >= 0)
            criteria.andIspayEqualTo(oSEntity.getIsPay());
        //1 ： 退款 0：未退款
        if( oSEntity.getiRefund() != null && oSEntity.getiRefund() >= 0)
            criteria.andIsRefundEqualTo(oSEntity.getiRefund());
        //快递id
        if( oSEntity.getExpressId() != null && oSEntity.getExpressId() > 0)
            criteria.andExpressIdEqualTo(oSEntity.getExpressId());
        //快递单号
        if( !StringUtils.isEmpty(oSEntity.getExpressNo()))
            criteria.andExpressNoEqualTo(oSEntity.getExpressNo());
        //
        if( oSEntity.getDeliverType() != null && oSEntity.getDeliverType() > 0)
            criteria.andDeliverTypeEqualTo(oSEntity.getDeliverType());

        if( oSEntity.getStart() != null)
            criteria.andCreatedTimeGreaterThanOrEqualTo(oSEntity.getStart());
        if( oSEntity.getEnd() != null)
            criteria.andCreatedTimeLessThanOrEqualTo(oSEntity.getEnd());

        List<WtOrder> wtOrders = wtOrderMapper.selectByExample(example);

        return PageInfo.of(wtOrders);
    }

    /**
     *
     * @param id
     * @return
     */
    public Map<String,Object> selectById(Integer id){
        Map<String,Object> res = new HashMap<>();
        WtOrder order = wtOrderMapper.selectByPrimaryKey(id);
        List<OrdersGoods> ordersGoods = ordersGoodsService.selectByOrderId(id);
        res.put("order",order);
        res.put("goods",ordersGoods);
        return res;
    }

    /**
     * 查询 退款订单
     * @param entity
     * @return
     */
    public PageInfo<WtOrder> selectReBackOrder(OrderReciveEntity entity){
        entity.getEntity().setiRefund(StaticPool.useful);
        return selectByEntity(entity);
    }

    /**
     * 查询 异议订单
     * @param entity
     * @return
     */
    public PageInfo<WtOrder> selectDifMeansOrder(OrderReciveEntity entity){
        entity.getEntity().setStatus(OrderStatus.DIF_MEANS.getNum());
        return selectByEntity(entity);
    }

}
