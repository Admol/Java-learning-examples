package com.admol.eureka.client.demo.controller;

import com.admol.eureka.client.demo.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : admol
 * @Date : 2018/11/11
 */
@RestController
public class HelloController{

    @Autowired
    DiscoveryClient discoveryClient;
//    @Autowired
//    HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        List<String> services = discoveryClient.getServices();
        return "hello!, this is a Eureka client demo project. my port:8081,  services:"+services;
    }
//    @RequestMapping("/hello2")
//    public String hello2(){
//        return helloService.hello();
//    }

}
