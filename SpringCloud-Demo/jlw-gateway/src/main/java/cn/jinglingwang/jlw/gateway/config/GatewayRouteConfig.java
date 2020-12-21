package cn.jinglingwang.jlw.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Map;

import static org.springframework.cloud.gateway.support.RouteMetadataUtils.CONNECT_TIMEOUT_ATTR;
import static org.springframework.cloud.gateway.support.RouteMetadataUtils.RESPONSE_TIMEOUT_ATTR;

/**
 * @author : jingling
 * @Date : 2020/12/8
 */
@Component
@Configuration
public class GatewayRouteConfig{

    @Resource(name = "ipKeyResolver")
    KeyResolver ipKeyResolver;
//    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                // 请求网关路径包含 /api/ec/** 的都会被路由到eureka-client
                .route("eureka-client",r->r.path("/api/ec/**")
                        .filters(f->f.stripPrefix(2))
                        .uri("lb://eureka-client"))
                // 可以配置多个route
                .route("eureka-client2",r->r.path("/api/ec2/**")
                        .filters(f->f.stripPrefix(2))
                        .uri("lb://eureka-client"))
                .route("eureka-provider", r -> r.path("/api/ep/**")
                        .filters(f->f.stripPrefix(2)
                                .requestRateLimiter(rate->rate.setKeyResolver(ipKeyResolver))
                                .circuitBreaker(c->c.setName("myCircuitBreaker").setFallbackUri("forward:/fallback").addStatusCode("500").addStatusCode("NOT_FOUND")))
                        .uri("lb://eureka-provider")
                        .metadata(RESPONSE_TIMEOUT_ATTR, 200)
                        .metadata(CONNECT_TIMEOUT_ATTR, 200))
                .build();
    }

}
