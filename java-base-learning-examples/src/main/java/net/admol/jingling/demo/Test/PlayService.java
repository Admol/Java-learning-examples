package net.admol.jingling.demo.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * @author : jingling
 * @Date : 2020/10/26
 */
@Service
public class PlayService{
    @Autowired
    private Map<String,TravelService> map;
    //"airPlaneTravelServiceImpl" -> {AirPlaneTravelServiceImpl@4489}
    //"trainTravelServiceImpl" -> {TrainTravelServiceImpl@4491}
    public TravelService getTravelService(String name){
        return map.get(name);
    }

    public static void main(String[] args){
        Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }
}
