package com.example.springboot.webflux.demo.router;

import com.example.springboot.webflux.demo.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @author : jingling
 * @Date : 2018/4/25
 */
@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> routerHello(HelloHandler helloHandler){
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                helloHandler::hello);
    }
}
