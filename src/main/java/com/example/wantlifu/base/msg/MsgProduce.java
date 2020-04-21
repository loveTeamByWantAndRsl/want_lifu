package com.example.wantlifu.base.msg;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 消息生产者
 *
 * @author want
 * @createTime 2020.02.19.12:26
 */
@Component
public class MsgProduce {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String PREFIX = "msg";

    @Value("${msg.exchange.name}")
    private String exchange;
    @Value("${msg.routing.key.name}")
    private String routingKey;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean pushEvent(Map<String,Object> map){
        try{
            String res = JSONObject.toJSONString(map);
            rabbitTemplate.convertAndSend(exchange, routingKey, MessageBuilder.withBody(res.getBytes("UTF8")).build());
        } catch (UnsupportedEncodingException e) {
            logger.warn(JSONObject.toJSONString(map)+"error");
            //throw new RuntimeException("服务繁忙");
            return false;
        }
        return true;
    }
}
