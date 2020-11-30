package cn.jinglingwang.ribbon.client.config;

import cn.jinglingwang.ribbon.client.annotation.ExcludeComponentScan;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author : jingling
 * @Date : 2020/11/27
 */
public class ProviderTempConfiguration{
    @Primary
    @Bean("providerTempRule")
    public IRule ribbonRule(){
        System.out.println("new ProviderTempConfiguration RandomRule");
        return new RandomRule();
    }
    @Bean
    public IPing ribbonPing() {
        //        return new PingUrl();
        return new NoOpPing();
    }
}
