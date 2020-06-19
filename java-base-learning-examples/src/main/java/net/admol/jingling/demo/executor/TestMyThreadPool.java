package net.admol.jingling.demo.executor;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : admol
 * @Date : 2020/6/19
 */
public class TestMyThreadPool{

    public static void main(String[] args) throws InterruptedException{
        MyThreadPoolExecutor myPool = new MyThreadPoolExecutor(2,3,new ArrayBlockingQueue(6));
        AtomicInteger taskIndex = new AtomicInteger(1);
        while(true){
            myPool.execute(new Runnable(){
                @SneakyThrows
                @Override
                public void run(){
                    System.out.println("执行任务:"+taskIndex.getAndIncrement());
                    // coreSize 为2时, 2秒足以, 不会出现maxSize的线程
//                    TimeUnit.MILLISECONDS.sleep(800);
                    // coreSize 线程处理不过来, 会启用max线程
//                    TimeUnit.MILLISECONDS.sleep(3000);
                    // max线程处理不过来, 会启用队列, 队列满了, 会执行拒绝策略
                    TimeUnit.MILLISECONDS.sleep(4000);
                }
            });
            // 每隔1s提交一个任务
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
