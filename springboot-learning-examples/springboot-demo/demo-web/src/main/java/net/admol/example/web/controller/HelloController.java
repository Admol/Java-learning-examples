package net.admol.example.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : admol
 * @Date : 2018/3/5
 */
@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello , this is a demo !";
    }
}
