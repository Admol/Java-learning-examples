package com.admol.consul.client.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulClientDemoApplication{

    public static void main(String[] args){
        SpringApplication.run(ConsulClientDemoApplication.class,args);
    }
}
