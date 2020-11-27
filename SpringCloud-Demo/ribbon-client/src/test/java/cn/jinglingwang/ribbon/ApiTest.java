package cn.jinglingwang.ribbon;

import cn.jinglingwang.ribbon.client.RibbonClientApplication;
import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RetryHandler;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * @author : jingling
 * @Date : 2020/11/26
 */

/***
 * Ribbon 原生API测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={RibbonClientApplication.class})
public class ApiTest{

    @Autowired
    private SpringClientFactory springClientFactory;



    @Test
    public void testApi(){

    }

    @Test
    public void testApi1(){
        for(int i = 1;i<=10;i++){
            String result = "";
            ILoadBalancer loadBalancer = springClientFactory.getLoadBalancer("eureka-provider");
            //List<Server> serverList = loadBalancer.getReachableServers();
            String path = "/queryPort";
            result = LoadBalancerCommand.<String>builder()
                    .withLoadBalancer(loadBalancer)
                    .build()
                    .submit(new ServerOperation<String>() {
                        @Override
                        public Observable<String> call(Server server) {
                            URL url;
                            try {
                                url = new URL("http://localhost:" + server.getPort() + path);
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                InputStream inputStream = conn.getInputStream();
                                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                                String line = null;
                                StringBuffer buffer = new StringBuffer();
                                while ((line = reader.readLine()) != null) {
                                    buffer.append(line);
                                }
                                reader.close();
                                return Observable.just(buffer.toString());
                            } catch (Exception e) {
                                return Observable.error(e);
                            }
                        }
                    }).toBlocking().first();

            System.out.println(result);
        }

    }
}
