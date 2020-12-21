package cn.jinglingwang.jlw.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @author : jingling
 * @Date : 2020/12/4
 */
@Component
public class LogFilter extends ZuulFilter{
    /**
     * 返回过滤器的类型，可选值有 pre、route、post、error 四种类型
     * @return
     */
    @Override
    public String filterType(){
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序，数字越小，优先级越高
     * 默认的filter的顺序可以在FilterConstants类中查看。
     * @return
     */
    @Override
    public int filterOrder(){
        // pre filter
        return PRE_DECORATION_FILTER_ORDER - 1 ;
        // ROUTE filter
        //return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1 ;
        // POST filter
        //return SEND_RESPONSE_FILTER_ORDER - 1 ;
    }

    /**
     * 决定了是否执行该过滤器，true 为执行，false 为不执行
     * @return
     */
    @Override
    public boolean shouldFilter(){
        return true;
    }

    /**
     * 如果shouldFilter（）为true，则将调用此方法。该方法是ZuulFilter的核心方法
     * @return 返回值会被忽略
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException{
        HttpServletRequest req = (HttpServletRequest) RequestContext.getCurrentContext().getRequest();
        System.out.println("ZUUL REQUEST:: " + req.getScheme() + " " + req.getRemoteAddr() + ":" + req.getRemotePort() + " uri::"+ req.getRequestURI()) ;

        RequestContext.getCurrentContext().setSendZuulResponse(false);
        RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        System.out.println("不是合法的请求路径,访问路径为:"+ req.getRequestURI());
        return null;
    }
}
