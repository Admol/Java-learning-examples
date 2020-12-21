package cn.jinglingwang.jlw.zuul.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : jingling
 * @Date : 2020/12/4
 */
@Component
public class EurekaClientFallbackProvider implements FallbackProvider{
    @Override
    public String getRoute(){
        // 路由的server-id，*：为所有的路由都配置回退
        return "eureka-client";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route,Throwable cause){
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private ClientHttpResponse response(HttpStatus status){
        return new ClientHttpResponse(){
            @Override
            public HttpStatus getStatusCode() throws IOException{
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException{
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException{
                return status.getReasonPhrase();
            }

            @Override
            public void close(){
            }

            @Override
            public InputStream getBody() throws IOException{
                return new ByteArrayInputStream("eureka-client 服务暂不可用，jinglingwang请你稍后重试!".getBytes());
            }

            @Override
            public HttpHeaders getHeaders(){
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
