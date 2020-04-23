package net.admol.jingling.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : admol
 * @Date : 2019/10/24
 */

@Slf4j
@Service
public class LogService{

    @AopLog("test save")
    public void testSave(String name){
        log.info("this is testSave method! name:{}",name);
    }

    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(new Runnable(){
            @Override
            public void run(){
                lock.lock();
                System.out.println(111);
//                lock.unlock();
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                lock.lock();
                System.out.println(2222);
//                lock.unlock();
            }
        }).start();
        System.out.println(4444);
    }
}
