package net.admol.jingling.demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.IntStream;

/**
 * @author : admol
 * @Date : 2020/10/29
 */
public class MyAQSLock{

    private final Sync sync;

    MyAQSLock(){
        sync = new Sync();
    }

    class Sync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int acquires){
            // 入参只能为1
            assert acquires == 1;
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases){
            assert releases == 1;
            if (getState() == 0){
                // 已经被释放了
                throw new IllegalMonitorStateException();
            }
            setState(0);
            return true;
        }
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

    }

    /**
     * 同步获得锁
     */
    public void lock(){
        sync.acquire(1);
    }

    /**
     * 尝试获得锁，如果没有获取到锁，则返回false
     */
    public boolean tryLock(){
        return sync.tryAcquire(1);
    }

    /**
     * 尝试获得锁，如果没有获取到锁，允许等待一段时间
     * @param timeout
     * @param unit
     * @return
     * @throws InterruptedException
     */
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException{
        return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }

    /**
     * 解锁
     */
    public void unLock(){
        sync.release(1);
    }

    /**
     * 判断锁是否已经被占用
     * @return
     */
    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    static int count = 0;
    public static void main(String[] args) throws InterruptedException{
        MyAQSLock myAQSLock = new MyAQSLock();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        IntStream.range(0,1000).forEach(i->new Thread(()->{
            myAQSLock.lock();
            try{
                IntStream.range(0,10000).forEach(j->{
                    count++;
                });
            }finally{
                myAQSLock.unLock();
            }
            countDownLatch.countDown();
        }).start());
        countDownLatch.await();
        System.out.println(count);
    }
}
