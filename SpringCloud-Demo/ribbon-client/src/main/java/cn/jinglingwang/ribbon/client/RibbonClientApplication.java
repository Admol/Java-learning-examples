package cn.jinglingwang.ribbon.client;

import cn.jinglingwang.ribbon.client.annotation.ExcludeComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(excludeFilters= {@ComponentScan.Filter(type= FilterType.ANNOTATION, value= {ExcludeComponentScan.class})})
public class RibbonClientApplication{

    public static void main(String[] args){
        SpringApplication.run(RibbonClientApplication.class,args);
    }

}
