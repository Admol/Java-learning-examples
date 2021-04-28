package net.admol.jingling.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 同步计数器 : 信号量
 * @author : jingling
 * @Date : 2018/1/5
 */
@Slf4j
public class TestSemaphore {

    private static final ExecutorService SINGLE_THREAD_POOL = new ThreadPoolExecutor(5, 5,
            15L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10000), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        // 每次允许最多3个任务连接
//        Semaphore semaphore = new Semaphore(3,true);
//        for (int i=0;i< 10;i++){
//            final int ss = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    log.info("用户name:{} 连接成功 , 连接数i:{} " , Thread.currentThread().getName(),ss);
//                    log.info("available:{},per:{},len:{},has:{} ",semaphore.availablePermits(),semaphore.drainPermits(),semaphore.getQueueLength());
//                    try{
//                        TimeUnit.SECONDS.sleep(5L);
//                        //获得连接许可
//                        semaphore.acquire();
//
//                        log.info("用户name:{} 连接并访问成功 , 连接i:{}, " , Thread.currentThread().getName(),ss);
//                        log.info("available:{},per:{},len:{},has:{} ",semaphore.availablePermits(),semaphore.getQueueLength(),semaphore.hasQueuedThreads());
//
//                        TimeUnit.SECONDS.sleep(5L);
//                        semaphore.release();
//                        log.info("用户name:{} 连接访问操作数据并退出成功 , 连接i:{}, " , Thread.currentThread().getName(),ss);
//                        log.info("available:{},per:{},len:{},has:{} ",semaphore.availablePermits(),semaphore.getQueueLength(),semaphore.hasQueuedThreads());
//
//                        TimeUnit.SECONDS.sleep(5L);
//                    }catch (Exception e){
//                        log.error("异常e:{}",e);
//                    }
//                }
//            }).start();
//        }


        Semaphore semaphore2 = new Semaphore(5);
        List<Integer> list = new ArrayList<>(10000);
        for (int i=0;i<10000;i++){
            list.add(i);
        }

        try{
            for (Integer integer : list){
                semaphore2.acquire();
                SINGLE_THREAD_POOL.submit(new Runnable() {
                    @Override
                    public void run() {
                        log.info("int:{}" ,integer);
                        try{
                            TimeUnit.SECONDS.sleep(5);
                        }catch (Exception e){
                            log.error("e:{}",e);
                        }
                        semaphore2.release();
                    }
                });
            }
        }catch (Exception e){
            log.error("e:{}",e);
        }

    }
}
