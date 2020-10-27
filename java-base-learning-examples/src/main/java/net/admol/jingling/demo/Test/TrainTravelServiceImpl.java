package net.admol.jingling.demo.Test;

import org.springframework.stereotype.Service;

/**
 * @author : jingling
 * @Date : 2020/10/26
 */
@Service(value="TRAIN")
public class TrainTravelServiceImpl implements TravelService{
    @Override
    public String travel(){
        return "坐火车旅行";
    }

    @Override
    public TravelEnum getType(){
        return TravelEnum.TRAIN;
    }
}
