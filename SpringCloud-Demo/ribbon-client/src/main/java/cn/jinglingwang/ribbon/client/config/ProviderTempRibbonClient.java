package cn.jinglingwang.ribbon.client.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author : jingling
 * @Date : 2020/11/27
 */
@RibbonClient(name = "eureka-provider-temp",configuration = ProviderTempConfiguration.class)
public class ProviderTempRibbonClient{

}
