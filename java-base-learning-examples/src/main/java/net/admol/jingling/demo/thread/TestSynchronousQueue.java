package net.admol.jingling.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列测试
 * SynchronousQueue 可以看作一个传球手,不存储数据,适用于传递性场景,每一个put操作需要等一个take操作
 * @author : jingling
 * @Date : 2018/1/4
 */
@Slf4j
public class TestSynchronousQueue {

    public static void main(String[] args) throws Exception {
        // true 公平策略
        SynchronousQueue<String>  sq = new SynchronousQueue(true);
        // 数量为1的信号量 , 相对于一个互斥锁
        Semaphore semaphore = new Semaphore(2);


        for (int i=0 ; i <10 ;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        String input = sq.take();
                        String output = dosome(input);
                        System.out.println(Thread.currentThread().getName() + ": " + output);
                        semaphore.release();
                    }catch (Exception e){

                    }
                }
            }).start();
        }
        // 10个线程生产数据
        for (int i=0 ; i <10 ;i++){
            sq.put(i+"");
            log.info("sq put :{}",i);
        }
    }
    public static String dosome(String input) throws Exception{
        TimeUnit.SECONDS.sleep(1);
        String output = input + ":" + System.currentTimeMillis()/1000;
        return output;

    }
}
