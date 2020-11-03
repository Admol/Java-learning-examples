package net.admol.jingling.demo.spring.event.java;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
public class OpenDoorListener implements DoorListener{
    @Override
    public void doorEvent(DoorEvent doorEvent){
        if(doorEvent.getState() == 1){
            System.out.println("门打开了");
        }
    }
}
