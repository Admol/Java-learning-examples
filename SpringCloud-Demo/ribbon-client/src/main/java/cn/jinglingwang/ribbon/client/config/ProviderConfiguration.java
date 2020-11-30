package cn.jinglingwang.ribbon.client.config;

import cn.jinglingwang.ribbon.client.annotation.ExcludeComponentScan;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jingling
 * @Date : 2020/11/27
 */
public class ProviderConfiguration{
    @Bean("providerRule")
    public IRule ribbonRule(){
        System.out.println("new ProviderConfiguration BestAvailableRule");
        return new BestAvailableRule();
    }
    @Bean
    public IPing ribbonPing() {
        //        return new PingUrl();
        return new NoOpPing();
    }
}
