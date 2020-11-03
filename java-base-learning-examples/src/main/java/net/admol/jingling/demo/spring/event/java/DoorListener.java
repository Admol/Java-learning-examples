package net.admol.jingling.demo.spring.event.java;

import java.util.EventListener;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
public interface DoorListener extends EventListener{
    void doorEvent(DoorEvent doorEvent);
}
