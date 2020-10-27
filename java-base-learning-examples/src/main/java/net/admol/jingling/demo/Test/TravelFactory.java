package net.admol.jingling.demo.Test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jingling
 * @Date : 2020/10/26
 */
@Component
public class TravelFactory implements ApplicationContextAware{
    private static HashMap<TravelEnum,TravelService> travelMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        Map<String, TravelService> map = applicationContext.getBeansOfType(TravelService.class);
        travelMap = new HashMap<>(map.size());
        map.forEach((k,v) -> travelMap.put(v.getType(),v));
    }

    public static TravelService getTravelByType(TravelEnum type){
        return travelMap.get(type);
    }
}
