package cn.jinglingwang.apolloclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jingling
 * @Date : 2020/12/22
 */
@RestController
public class HelloController{

    @Value("${name:jinglingwang}")
    private String name;

    @GetMapping("hello")
    public String hello(){
        return "hello!";
    }
    @GetMapping("apollo")
    public String apollo(){
        return "apollo config value:"+name;
    }
}
