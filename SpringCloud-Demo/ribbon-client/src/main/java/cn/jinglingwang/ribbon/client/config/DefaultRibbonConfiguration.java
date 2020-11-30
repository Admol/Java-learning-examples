package cn.jinglingwang.ribbon.client.config;

import cn.jinglingwang.ribbon.client.annotation.ExcludeComponentScan;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jingling
 * @Date : 2020/11/26
 */
@Configuration()
public class DefaultRibbonConfiguration{

    @Bean
    public IRule iRule() {
        //最佳策略，选择并发量最小的服务
//        return new BestAvailableRule();
//        return new RetryRule();
//        return new PredicateBasedRule();
        System.out.println("new RoundRobinRule");
        return new RoundRobinRule();
//        return new RandomRule();
//        return new AvailabilityFilteringRule();
//        return new ClientConfigEnabledRoundRobinRule();
    }

    @Bean
    public IPing ribbonPing() {
//        return new PingUrl();
        return new DummyPing();
    }


}
