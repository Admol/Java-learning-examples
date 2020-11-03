package net.admol.jingling.demo.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
@Component
public class UserRegisterSmsListener{

    @Order(-2)
    @Async("asyncThreadPool")
    @EventListener
    public void handleUserEvent(UserDTO userDTO){
        System.out.println(Thread.currentThread().getName() + " 监听到用户注册，准备发送短信，user:"+userDTO.toString());
    }
}
