package cn.jinglingwang.ribbon.client.feign;

//import cn.jinglingwang.ribbon.client.config.ProviderTempConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * eureka-provider-temp 是把eureka-provider项目的服务名改为eureka-provider-temp启动3个节点
 * 为了方便区分和eureka-provider服务的负载均衡的策略区别
 * @author : jingling
 * @Date : 2020/11/27
 */
@FeignClient(value = "eureka-provider-temp")
public interface ProviderTempFeign{

    @RequestMapping("/queryPort")
    String queryPort();
}
