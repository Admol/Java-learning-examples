package cn.jinglingwang.ribbon.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : jingling
 * @Date : 2020/11/26
 */
@FeignClient(value = "eureka-provider")
public interface ProviderFeign{
    /**
     * 调用服务提供方，其中会返回服务提供者的端口信息
     * @return jinglingwang.cn
     */
    @RequestMapping("/queryPort")
    String queryPort();
}
