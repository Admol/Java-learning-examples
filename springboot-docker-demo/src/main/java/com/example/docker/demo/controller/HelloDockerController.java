package com.example.docker.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : admol
 * @Date : 2020/4/28
 */
@RestController
public class HelloDockerController{

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello,this is a spring web docker demo!");
        return "hello,this is a spring web docker demo!";
    }
    @RequestMapping("/bug")
    public String bug(){
        System.out.println("hello,this is a bug!");
        Boolean flag = true;
        while(flag){

        }
        return "hello,this is a bug!";
    }
}
