package com.example.elastic.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jingling
 * @Date : 2018/3/9
 */
@Slf4j
@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String hello(){
        return "hello";
    }
}
