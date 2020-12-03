package cn.jinglingwang.ribbon.client.fallback.factory;

import cn.jinglingwang.ribbon.client.feign.ProviderFeign;
import cn.jinglingwang.ribbon.client.feign.ProviderTempFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author : jingling
 * @Date : 2020/12/1
 */
@Component
public class ProviderFeignFallbackFactory implements FallbackFactory<ProviderFeign>{

    @Override
    public ProviderFeign create(Throwable cause){
        return new ProviderFeign(){
            @Override
            public String queryPort(){
                return "sorry ProviderFeignFallbackFactory, jinglingwang.cn no back! why? ==>" + cause.getCause();
            }
        };
    }
}
