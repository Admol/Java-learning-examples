package net.admol.jingling.demo.Test;

import org.springframework.stereotype.Service;

/**
 * @author : jingling
 * @Date : 2020/10/26
 */
@Service(value="AIRPLANE")
public class AirPlaneTravelServiceImpl implements TravelService{
    @Override
    public String travel(){
        return "坐飞机旅行";
    }

    @Override
    public TravelEnum getType(){
        return TravelEnum.AIRPLANE;
    }
}
