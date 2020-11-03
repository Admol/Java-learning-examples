package net.admol.jingling.demo.spring.event.java;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
public class CloseDoorEvent implements DoorListener{
    @Override
    public void doorEvent(DoorEvent doorEvent){
        if(doorEvent.getState() == -1){
            System.out.println("门关上了");
        }
    }
}
