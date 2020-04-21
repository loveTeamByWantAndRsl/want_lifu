package com.example.wantlifu.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.config.AliPayConfig;
import com.example.wantlifu.controller.reciveEntity.OrderEntity;
import com.example.wantlifu.controller.reciveEntity.PayEntity;
import com.example.wantlifu.entity.UserAddress;
import com.example.wantlifu.entity.WtOrder;
import com.example.wantlifu.exception.TestException;
import com.example.wantlifu.service.IAliPayService;
import com.example.wantlifu.service.impl.LifuService;
import com.example.wantlifu.service.impl.OrderService;
import com.example.wantlifu.service.impl.OrdersGoodsService;
import com.example.wantlifu.service.impl.UserAddressService;
import com.example.wantlifu.service.security.LoginEntityHelper;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 王志坚
 * @createTime 2019.12.07.10:54
 */
@Controller
public class HelloController {

    @Autowired
    IAliPayService aliPayService;
    @Autowired
    AliPayConfig aliPayConfig;
    @Autowired
    LifuService lifuService;
    @Autowired
    OrderService orderService;
    @Autowired
    LoginEntityHelper loginEntityHelper;
    @Autowired
    UserAddressService addressService;
    @Autowired
    OrdersGoodsService ordersGoodsService;


//    @ResponseBody
//    @RequestMapping("ms")
//    public ApiResponse ms(@RequestBody B b){
//        System.out.println("B = " + b);
//        return ApiResponseFactory.genSuccessApiResponse("",b);
//    }

        @RequestMapping("/user/pay")
        public String payTest(@RequestParam String idString,@RequestParam String countString
                ,@RequestParam String sizeString,@RequestParam String colorString
                ,@RequestParam Integer addressId,HttpServletResponse httpResponse){
            PayEntity payEntity = new PayEntity(idString,countString,sizeString,colorString);
            OrderEntity orderEntity = lifuService.setCountAndValidaCount(payEntity);

            if( orderEntity == null)
                return "500";
            //订单生成
            WtOrder order = new WtOrder();
            order.setUserid(loginEntityHelper.getOnlineEntity().getId());
            order.setUserName(loginEntityHelper.getOnlineEntity().getEntityName());

            UserAddress address = addressService.getAddressById(addressId);
            if( address == null)
                return "500";
            order.setAddress(address.getAllAddress());
            //商户订单号，商户网站订单系统中唯一订单号，必填
            //生成随机Id
            String out_trade_no = UUID.randomUUID().toString();

            order.setOrderNo(out_trade_no);
            order.setLifuTotalPrice(new BigDecimal(orderEntity.getTotal_amount()));
            order.setRealTotalMoney(new BigDecimal(orderEntity.getTotal_amount()));
            Map<String, String> map = orderService.addOrder(order);
            if(!map.containsKey(StaticPool.SUCCESS))
                return "500";
            ordersGoodsService.addGoods(orderEntity.getGoods(),order.getId());

            String form = aliPayService.genPage(out_trade_no,orderEntity.getTotal_amount()
                    ,orderEntity.getSubject(),orderEntity.getBody());
            httpResponse.setContentType("text/html;charset=" + aliPayConfig.CHARSET);
            try{
                httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
                httpResponse.getWriter().flush();
                httpResponse.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    @GetMapping("oss/upload")
    public String upload(HttpServletResponse httpResponse){
        return "/upload";
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    @ResponseBody
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params
                ,aliPayConfig.ALIPAY_PUBLIC_KEY, aliPayConfig.CHARSET, aliPayConfig.SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
            aliPayService.updateById(out_trade_no);
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }
    @GetMapping("refund")
    @ResponseBody
    public void test_trade_refund(String outTradeNo,HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try{
            PrintWriter out = response.getWriter();
            String result = aliPayService.refund(outTradeNo);
            out.println(result);//以下写自己的订单退款代码
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试 全局异常
     * @return
     */
    @GetMapping("testException")
    public ApiResponse testException(){
            throw new TestException();
    }
}
