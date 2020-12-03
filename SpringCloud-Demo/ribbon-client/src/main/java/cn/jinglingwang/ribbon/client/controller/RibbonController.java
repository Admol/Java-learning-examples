package cn.jinglingwang.ribbon.client.controller;

import cn.jinglingwang.ribbon.client.feign.ProviderFeign;
import cn.jinglingwang.ribbon.client.feign.ProviderTempFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(groupKey = "DefaultGroupKey")
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

//    @HystrixCommand(commandKey = "queryPort",commandProperties ={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),//超时时间，默认1000，即1秒
//            @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),//信号量隔离级别
//            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "50") //信号量模式下，最大请求并发数，默认10
//        },fallbackMethod = "queryPortFallBack")
    @GetMapping("queryPort")
    public String queryPort(){
        return providerFeign.queryPort();
    }

//    @HystrixCommand(commandKey = "queryTempPort",groupKey="eureka-provider-temp",
//            threadPoolProperties = {
//                @HystrixProperty(name = "coreSize", value = "30"),
//                @HystrixProperty(name = "maxQueueSize", value = "101"),
//                @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
//                @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
//                @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
//                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
//            }
//            ,fallbackMethod = "queryTempPortFallBack")
    @GetMapping("queryTempPort")
    public String queryTempPort(){
        return providerTempFeign.queryPort();
    }

    @HystrixCommand(groupKey = "SpecificGroupKey") // command overrides default group key
    public Object commandOverridesGroupKey() {
        return null;
    }

    /**
     * queryPort 方法的失败回调
     * @return
     */
    private String queryPortFallBack(){
        return "sorry queryPort,jinglingwang.cn no back!";
    }

    /**
     * queryTempPort 方法的失败回调
     * @return
     */
    private String queryTempPortFallBack(){
        return "sorry queryTempPort,jinglingwang.cn no back!";
    }
}
