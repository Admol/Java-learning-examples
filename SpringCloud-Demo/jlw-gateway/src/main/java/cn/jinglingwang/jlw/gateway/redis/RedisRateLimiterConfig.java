package cn.jinglingwang.jlw.gateway.redis;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * @author : jingling
 * @Date : 2020/12/10
 */
@Configuration
public class RedisRateLimiterConfig{
//    @Bean
//    @Primary
//    KeyResolver phoneKeyResolver() {
//        // 根据请求参数中的phone进行限流
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("phone"));
//    }
    @Bean
    public KeyResolver ipKeyResolver() {
        // 根据访问IP进行限流
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
