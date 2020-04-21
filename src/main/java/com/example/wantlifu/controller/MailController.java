package com.example.wantlifu.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @createTime 2019.12.26.11:55
 */
@RestController
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String PREFIX = "mail";

    @Value("${mail.exchange.name}")
    private String exchange;
    @Value("${mail.routing.key.name}")
    private String routingKey;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/getCode")
    public ApiResponse getCode(String email, String type){
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(type))
            return ApiResponseFactory.genFailApiResponse("参数错误！");
        try{
//            rabbitTemplate.setExchange(exchange);
//            rabbitTemplate.setRoutingKey(routingKey);
            String code;
            if( redisTemplate.hasKey(email))
                code = (String) redisTemplate.opsForValue().get(email);
            else
                code = UUID.randomUUID().toString().replaceAll("-","").substring(0,6);

            Map<String,String> map = new HashMap<>();
            map.put("code",code);
            map.put("mail",email);
            map.put("type",type);
            String res = JSONObject.toJSONString(map);
            rabbitTemplate.convertAndSend(exchange, routingKey, MessageBuilder.withBody(res.getBytes("UTF8")).build());
//            rabbitTemplate.convertAndSend(MessageBuilder.withBody(res.getBytes("UTF8")).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponseFactory.genFailApiResponse("服务繁忙");
        }
        return ApiResponseFactory.genSuccessApiResponse("邮件发送成功，请去邮箱接收");
    }
}
