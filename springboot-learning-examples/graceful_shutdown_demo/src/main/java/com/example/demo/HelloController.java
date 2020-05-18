package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : jingling
 * @Date : 2020/5/18
 */
@Slf4j
@RestController
public class HelloController{

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("sleep")
    public String sleep(Integer timeout){
        try{
            log.info("begin sleep:{}",timeout);
            TimeUnit.SECONDS.sleep(timeout);
            log.info("end sleep:{}",timeout);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "sleep:" + timeout;
    }

}
