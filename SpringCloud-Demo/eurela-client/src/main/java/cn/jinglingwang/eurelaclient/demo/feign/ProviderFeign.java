package cn.jinglingwang.eurelaclient.demo.feign;

import cn.jinglingwang.eurelaclient.demo.config.ProviderFeignConfiguration;
import cn.jinglingwang.eurelaclient.demo.dto.UserDTO;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : jingling
 * @Date : 2020/11/24
 */
@FeignClient(value = "eureka-provider",configuration = ProviderFeignConfiguration.class)
public interface ProviderFeign{
    /**
     * 调用 eureka-provider 的 hello 接口
     * @return
     */
    @RequestMapping("/hello")
    String hello();

    /**
     * 发起 get 多参数查询
     * @param userDTO
     * @return
     */
    @RequestMapping("/query")
    String query(@QueryMap UserDTO userDTO);

    /**
     * 和上面的接口区别是使用了 @SpringQueryMap 注解
     * @param userDTO
     * @return
     */
    @RequestMapping("/query")
    String query2(@SpringQueryMap UserDTO userDTO);

    /**
     * 发起 get 多参数查询,但是没有返回值
     * @param userDTO
     * @return
     */
    @RequestMapping("/queryNoReturn")
    void queryNoReturn(@QueryMap UserDTO userDTO);
}
