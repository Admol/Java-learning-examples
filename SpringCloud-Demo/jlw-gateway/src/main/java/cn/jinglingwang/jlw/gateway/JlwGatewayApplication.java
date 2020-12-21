package cn.jinglingwang.jlw.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class JlwGatewayApplication{

    public static void main(String[] args){
        SpringApplication.run(JlwGatewayApplication.class,args);
    }

}
