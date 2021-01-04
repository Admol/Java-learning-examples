package cn.jinglingwang.jlwactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jingling
 * @Date : 2021/1/4
 */
@RestController
public class HelloController{

    @GetMapping("/hello")
    public String hello(){
        return "hello,jinglingwang.cn";
    }
}
