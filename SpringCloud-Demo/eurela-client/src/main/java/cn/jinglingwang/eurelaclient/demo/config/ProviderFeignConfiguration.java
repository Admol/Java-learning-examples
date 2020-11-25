package cn.jinglingwang.eurelaclient.demo.config;

import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author : jingling
 * @Date : 2020/11/25
 */
@Configuration
public class ProviderFeignConfiguration{
    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.BASIC;
    }
    @Bean
    public BasicAuthRequestInterceptor basicAuth(){
        return new BasicAuthRequestInterceptor("username","jinglingwang.cn");
    }
    @Bean
    public Request.Options options(){
        return new Request.Options(5,TimeUnit.SECONDS,5,TimeUnit.SECONDS,true);
    }
}
