package net.admol.jingling.demo.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : jingling
 * @Date : 2020/11/2
 */
@Component
//public class UserRegisterEmailListener implements ApplicationListener<UserDTO>{
public class UserRegisterEmailListener implements SmartApplicationListener{


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass){
        return aClass == UserDTO.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass){
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent){
        System.out.println("监听到用户注册，准备发送邮件，user:" + applicationEvent.toString());
    }

    @Override
    public int getOrder(){
        return 1;
    }
}
