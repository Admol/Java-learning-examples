package com.admol.eureka.client.demo.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : admol
 * @Date : 2019/11/15
 */
@Configuration
public class FeignConfig{

    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }


    @Bean
    public Request.Options options(){
        return new Request.Options(1000,1000);
    }

}
