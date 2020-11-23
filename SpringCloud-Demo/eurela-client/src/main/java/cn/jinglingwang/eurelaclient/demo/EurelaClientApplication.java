package cn.jinglingwang.eurelaclient.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurelaClientApplication{

    public static void main(String[] args){
        SpringApplication.run(EurelaClientApplication.class,args);
    }

}
