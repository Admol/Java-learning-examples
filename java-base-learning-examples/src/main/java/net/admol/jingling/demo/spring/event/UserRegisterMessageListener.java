package net.admol.jingling.demo.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : admol
 * @Date : 2020/11/2
 */
@Component
//public class UserRegisterMessageListener implements ApplicationListener<UserDTO>{
public class UserRegisterMessageListener implements SmartApplicationListener{


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType){
        return eventType == UserDTO.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType){
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event){
        System.out.println("监听到用户注册，给新用户发送首条站内短消息，user:" + event.toString());
    }

    @Override
    public int getOrder(){
        return -1;
    }
}
