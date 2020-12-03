package cn.jinglingwang.ribbon.client.fallback;

import cn.jinglingwang.ribbon.client.feign.ProviderTempFeign;
import org.springframework.stereotype.Component;

/**
 * @author : jingling
 * @Date : 2020/12/1
 */
@Component
public class ProviderTempFeignFallback implements ProviderTempFeign{

    @Override
    public String queryPort(){
        return "sorry ProviderTempFeign, jinglingwang.cn no back!";
    }
}
