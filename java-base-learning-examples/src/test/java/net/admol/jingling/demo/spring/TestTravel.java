package net.admol.jingling.demo.spring;

import net.admol.jingling.demo.Test.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : jingling
 * @Date : 2020/10/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTravel{
    @Autowired
    private PlayService playService;

    @Test
    public void test(){
        System.out.println(TravelFactory.getTravelByType(TravelEnum.AIRPLANE).travel());
        System.out.println(TravelFactory.getTravelByType(TravelEnum.TRAIN).travel());
    }
    @Test
    public void test2(){
        System.out.println(playService.getTravelService(TravelEnum.AIRPLANE.name()).travel());
        System.out.println(playService.getTravelService(TravelEnum.TRAIN.name()).travel());
    }
}
