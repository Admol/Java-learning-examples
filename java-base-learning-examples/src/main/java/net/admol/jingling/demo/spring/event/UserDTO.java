package net.admol.jingling.demo.spring.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
@Getter
@Setter
@ToString
public class UserDTO extends ApplicationEvent{
    private Integer userId;
    private String name;
    private Integer age;

    public UserDTO(Object source){
        super(source);
    }
}
