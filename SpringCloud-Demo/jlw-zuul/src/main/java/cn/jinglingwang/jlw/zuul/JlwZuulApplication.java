package cn.jinglingwang.jlw.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableZuulProxy
@SpringBootApplication
public class JlwZuulApplication{

    public static void main(String[] args){
        SpringApplication.run(JlwZuulApplication.class,args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 配置跨源请求处理
             * @param registry
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/path/**")
                        .allowedOrigins("https://jinglingwang.cn")
                        .allowedMethods("GET", "POST");
            }
        };
    }
}
