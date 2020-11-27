package cn.jinglingwang.ribbon.client.config;

import cn.jinglingwang.ribbon.client.annotation.ExcludeComponentScan;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jingling
 * @Date : 2020/11/27
 */
//@Configuration
//@ExcludeComponentScan
public class ProviderTempConfiguration{
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
