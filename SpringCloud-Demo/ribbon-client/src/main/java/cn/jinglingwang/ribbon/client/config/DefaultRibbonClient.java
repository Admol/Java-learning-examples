package cn.jinglingwang.ribbon.client.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 1. 为Ribbon所有的客户端配置默认的配置
 * @author : jingling
 * @Date : 2020/11/26
 */
@RibbonClients(defaultConfiguration = DefaultRibbonConfiguration.class)
public class DefaultRibbonClient{

}
