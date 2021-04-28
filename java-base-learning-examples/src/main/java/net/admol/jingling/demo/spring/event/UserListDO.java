package net.admol.jingling.demo.spring.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author : jingling
 * @Date : 2021/3/3
 */
@Getter
@Setter
@ToString
public class UserListDO extends ApplicationEvent{

    public UserListDO(Object source){
        super(source);
    }
    private List<String> list;
}
