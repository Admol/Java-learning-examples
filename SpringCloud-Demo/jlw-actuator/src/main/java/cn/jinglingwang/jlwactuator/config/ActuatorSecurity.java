package cn.jinglingwang.jlwactuator.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : jingling
 * @Date : 2020/12/31
 */
@Configuration(proxyBeanMethods = false)
public class ActuatorSecurity extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 确保所有端点都具有ENDPOINT_ADMIN角色
//        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
//                requests.anyRequest().hasRole("ENDPOINT_ADMIN"));
        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
                requests.anyRequest().permitAll());
        http.httpBasic();
    }
}