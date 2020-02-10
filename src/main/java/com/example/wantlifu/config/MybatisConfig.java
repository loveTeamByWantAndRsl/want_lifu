package com.example.wantlifu.config;

import com.example.wantlifu.dao.PriceAreaMapper;
import com.example.wantlifu.service.search.RentValueBlock;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author 王志坚
 * @createTime 2019.12.07.10:43
 */
@Configuration
@MapperScan("com.example.wantlifu.dao")
public class MybatisConfig implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Bean
    public RentValueBlock rentValueBlock(){
        PriceAreaMapper priceAreaMapper = (PriceAreaMapper)applicationContext.getBean("priceAreaMapper");
        return new RentValueBlock(priceAreaMapper);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
