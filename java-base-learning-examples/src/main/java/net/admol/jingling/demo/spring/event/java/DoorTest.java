package net.admol.jingling.demo.spring.event.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
public class DoorTest{

    public static void main(String[] args){
        List<DoorListener> list = new ArrayList<>();
        list.add(new OpenDoorListener());
        list.add(new CloseDoorEvent());
        for(DoorListener listener : list){
            listener.doorEvent(new DoorEvent(listener,-1));
            listener.doorEvent(new DoorEvent(listener,1));
        }
    }
}
