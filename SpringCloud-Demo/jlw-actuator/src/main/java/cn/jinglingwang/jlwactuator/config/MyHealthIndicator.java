package cn.jinglingwang.jlwactuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义健康指标
 * @author : jingling
 * @Date : 2020/12/31
 */
@Component
public class MyHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        //int errorCode = checkError();
        int errorCode = 1;
        if (errorCode != 1) {
            return Health.down().withDetail("Error Code", "https://jinglingwang.cn/ not found").build();
        }
        return Health.up()
                .withDetail("code","200")
                .withDetail("message","https://jinglingwang.cn/")
                .build();
    }

}