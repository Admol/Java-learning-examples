package net.admol.jingling.demo.spring.event.java;

import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
@Getter
@Setter
public class DoorEvent extends EventObject{

    int state;

    public DoorEvent(Object source){
        super(source);
    }
    public DoorEvent(Object source,int state){
        super(source);
        this.state = state;
    }
}
