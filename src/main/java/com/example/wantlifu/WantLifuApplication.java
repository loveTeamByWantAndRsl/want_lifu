package com.example.wantlifu;

import com.example.wantlifu.config.AliPayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class WantLifuApplication {
    @Bean
    public AliPayConfig aliPayConfig(){
        return new AliPayConfig();
    }
    @Bean
    public ErrorProperties errorProperties(){
        return new ErrorProperties();
    }
    public static void main(String[] args) {
        SpringApplication.run(WantLifuApplication.class, args);
    }

}
