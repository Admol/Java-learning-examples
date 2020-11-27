package cn.jinglingwang.ribbon.client.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jingling
 * @Date : 2020/11/26
 */
@Configuration()
public class DefaultRibbonConfig{

    @Bean
    public IRule ribbonRule() {
        // 最佳策略，选择并发量最小的服务
//        return new BestAvailableRule();
        return new RoundRobinRule();
//        return new RandomRule();
    }

    @Bean
    public IPing ribbonPing() {
//        return new PingUrl();
        return new NoOpPing();
    }

}
