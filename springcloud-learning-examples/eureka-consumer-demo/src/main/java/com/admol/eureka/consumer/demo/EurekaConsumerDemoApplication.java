package com.admol.eureka.consumer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerDemoApplication{

    public static void main(String[] args){
        SpringApplication.run(EurekaConsumerDemoApplication.class,args);

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
