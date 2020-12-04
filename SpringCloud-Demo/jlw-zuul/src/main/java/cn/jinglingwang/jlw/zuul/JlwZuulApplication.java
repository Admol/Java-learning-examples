package cn.jinglingwang.jlw.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class JlwZuulApplication{

    public static void main(String[] args){
        SpringApplication.run(JlwZuulApplication.class,args);
    }

}
