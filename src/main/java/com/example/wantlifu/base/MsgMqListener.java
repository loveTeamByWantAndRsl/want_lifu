package com.example.wantlifu.base;

import com.alibaba.fastjson.JSONObject;
import com.example.wantlifu.base.msg.MsgHandler;
import com.example.wantlifu.base.msg.Type;
import com.example.wantlifu.service.ISendMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @createTime 2019.12.26.15:08
 */
@Component
@RabbitListener(queues="${msg.queue.name}")
public class MsgMqListener implements ApplicationContextAware, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(MsgMqListener.class);
    private ApplicationContext applicationContext;
    private Map<Type, List<MsgHandler>> map;

    @Autowired
    RedisTemplate redisTemplate;



    @RabbitHandler
    public void consumeMailQueue(@Payload byte[] message){
        Map<String,Object> map = (Map<String,Object>)JSONObject.parse(message);
        Type type = (Type)map.get(Type.typeStr);
        List<MsgHandler> msgHandlers = this.map.get(type);
        if(msgHandlers == null){
            logger.error("not found handler" + type);
            return;
        }
        for(MsgHandler handler : msgHandlers){
            handler.doHandler(map);
        }


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, MsgHandler> beans = applicationContext.getBeansOfType(MsgHandler.class);
        map = new HashMap<>();

        Iterator<MsgHandler> iterator = beans.values().iterator();
        while (iterator.hasNext()){
            MsgHandler msgHandler = iterator.next();
            List<Type> support = msgHandler.getSupport();
            for(Type t : support){
                if( !map.containsKey(t))
                    map.put(t,new ArrayList<>());
                map.get(t).add(msgHandler);
            }
        }
    }
}
