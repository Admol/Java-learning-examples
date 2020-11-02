package net.admol.jingling.demo.lock;


import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author : jingling
 * @Date : 2020/10/30
 */
public class MyAqsSharedLock{

    private final int maxSharedValue = 2;

    private final Sync sync;

    MyAqsSharedLock(){
        sync = new Sync();
    }
    class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected int tryAcquireShared(int arg){
            while(true){
                int state = getState();
                if(state >= maxSharedValue){
                    return -1;
                }
                if(compareAndSetState(state,state + arg)){
                    return getState();
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg){
            while(true){
                int state = getState();
                if(compareAndSetState(state,state - arg)){
                    return true;
                }
            }
        }
    }
    /** 加锁 */
    public void lock(){
        sync.acquireShared(1);
    }
    public boolean tryLock(){
        return sync.tryAcquireShared(1) >= 0;
    }
    /** 解锁 */
    public void unLock(){
        sync.releaseShared(1);
    }

    public static void main(String[] args){
        MyAqsSharedLock lock = new MyAqsSharedLock();
//        lock.lock();
//        System.out.println(1);
//        lock.lock();
//        System.out.println(2);
//        new Thread(new Runnable(){
//            @SneakyThrows
//            @Override
//            public void run(){
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("lock.unLock");
//                lock.unLock();
//            }
//        }).start();
//        lock.lock();
//        System.out.println(3);

        IntStream.range(0,5).forEach(i -> new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                while(true){
                    lock.lock();
                    try{
                        System.out.println(Thread.currentThread().getName()+"：执行。。。时间："+ LocalDateTime.now());
                        TimeUnit.SECONDS.sleep(2);
                    }finally{
                        lock.unLock();
                        TimeUnit.SECONDS.sleep(1);
                    }

                }
            }
        },"T"+i).start());
    }
}
