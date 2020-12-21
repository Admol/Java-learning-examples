package cn.jinglingwang.jlw.gateway.custom;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * @author : jingling
 * @Date : 2020/12/10
 */
@Component
public class AddHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<AddHeaderGatewayFilterFactory.Config>{

    public AddHeaderGatewayFilterFactory() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config){
        return (exchange, chain) -> {
            // 如果要构建“前置”过滤器，则需要在调用chain.filter之前处理
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header("source", "jinglingwang.cn").build();
            //使用构建器来处理请求
            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
