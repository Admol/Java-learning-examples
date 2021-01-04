package cn.jinglingwang.apolloclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApolloClientApplication{


    public static void main(String[] args){
        SpringApplication.run(ApolloClientApplication.class,args);
    }

}
