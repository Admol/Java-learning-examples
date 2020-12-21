package cn.jinglingwang.jlw.gateway.custom;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author : jingling
 * @Date : 2020/12/10
 */
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory(){
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config){
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                String host = exchange.getRequest().getHeaders().getFirst("Host");
                return "jinglingwang.cn".equalsIgnoreCase(host);
            }

            @Override
            public String toString() {
                return String.format("host: name=%s ", config.host);
            }
        };
    }

    public static class Config {
        //自定义过滤器的配置属性
        @NotEmpty
        private String host;
    }

}