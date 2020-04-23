package com.admol.eureka.client.demo.feign;
import com.admol.eureka.client.demo.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : admol
 * @Date : 2019/11/15
 */
@FeignClient(value = "eureka-client-demo2",configuration = FeignConfig.class)
public interface HelloService{

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}
