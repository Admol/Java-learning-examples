package cn.jinglingwang.jlw.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jingling
 * @Date : 2020/12/9
 */
@RestController
public class FallbackController{
    @GetMapping("/fallback")
    public Object fallback() {

        Map<String,Object> result = new HashMap<>(3);
        result.put("data","jinglingwang.cn");
        result.put("message","Get request fallback!");
        result.put("code",500);
        return result;
    }
}
