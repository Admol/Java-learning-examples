package com.admol.eureka.consumer.ribbon.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : admol
 * @Date : 2018/11/11
 */

@RestController
public class HelloController{
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://eureka-client-demo/hello", String.class);
    }
}
