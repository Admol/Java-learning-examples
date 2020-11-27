package cn.jinglingwang.ribbon.client.controller;

import cn.jinglingwang.ribbon.client.feign.ProviderFeign;
import cn.jinglingwang.ribbon.client.feign.ProviderTempFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author : jingling
 * @Date : 2020/11/26
 */
@RestController
public class RibbonController{
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProviderFeign providerFeign;
    @Autowired
    private ProviderTempFeign providerTempFeign;
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("ribbonApi")
    public String ribbonApi() throws Exception{
        ServiceInstance instance = loadBalancer.choose("eureka-provider");
        URL url = new URL("http://localhost:" + instance.getPort() + "/queryPort");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        return Observable.just(buffer.toString()).toBlocking().first();
    }
    @GetMapping("queryPortByRest")
    public String queryPortByRest(){
        return restTemplate.getForEntity("http://eureka-provider/queryPort",String.class).getBody();
    }
    @GetMapping("queryPort")
    public String queryPort(){
        return providerFeign.queryPort();
    }

    @GetMapping("queryTempPort")
    public String queryTempPort(){
        return providerTempFeign.queryPort();
    }
}
