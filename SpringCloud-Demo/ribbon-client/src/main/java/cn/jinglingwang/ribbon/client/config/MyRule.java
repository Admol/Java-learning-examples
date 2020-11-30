package cn.jinglingwang.ribbon.client.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : jingling
 * @Date : 2020/11/30
 */
public class MyRule implements IRule{
    private static Logger log = LoggerFactory.getLogger(MyRule.class);

    private ILoadBalancer lb;
    @Override
    public Server choose(Object key){
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }
            // 是轮询、随机、加权、hash？自己实现从server list中选择一个server
            // 这里写简单点，总是请求第一台服务，这样的逻辑是不会用到真实的环境的
            server = allList.get(0);
        }
        return server;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb){
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer(){
        return lb;
    }
}
