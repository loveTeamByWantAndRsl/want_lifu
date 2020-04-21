package com.example.wantlifu.util.order.help;

/**
 * @author want
 * @createTime 2020.02.26.10:06
 */
public enum OrderStatus {
    //未支付
    NOT_PAY(1)
    //支付完毕 -- 用户等待商家发货
    ,PAY_OVER(2)

//    ,WAIT_FA_HUO(3)
    //商家填写完毕之后 -- 显示为等待收获
    //用户显示为 已发货并给出确认收货按钮
    ,FA_HUO(3)
    //用户显示为 -- 返还
    //商家显示 -- 退还已发货，可以点击确认收获
    ,WAIT_BACK(4)
    //商家收完货，显示 关闭订单 -- 礼服损坏 -- 押金扣除
    ,ACEEPT(5)
    //用户显示 -- 同意 -- 提出异议
    //商家显示等待用户同意，--关闭订单
    ,DISCOUNT_MONEY(6)
    //异议
    //用户显示 等待商家 新的 扣除
    //商家，显示 关闭订单 -- 礼服损坏 -- 押金扣除
    ,DIF_MEANS(7)
    //订单关闭
    ,OVER(8)
    //退货订单
    ,REBACK_ORDER(9);
    //定制路线暂时 未考虑

    int num;

    OrderStatus(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
