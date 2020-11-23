package net.admol.jingling.demo.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
/**
 * @author : admol
 * @Date : 2020/11/17
 */
public class StampedLockTest{
    public static void main(String[] args) throws InterruptedException{

        testCowaitStack();
//        testDeadLock();

    }

    /**
     * StampedLock 同一个线程先获取读锁，再获取写锁也会死锁
     * @throws InterruptedException
     */
    private static void testDeadLock() throws InterruptedException{
        StampedLock sl = new StampedLock();
        long  wstamp = sl.readLock();
        wstamp = sl.writeLock();
        System.out.println("nothing");
    }
    /**
     * main线程先获取写锁不释放，之后T0，T1，T2，T3线程先后去获取读锁，最后断点观察整个排队队列的情况
     * @throws InterruptedException
     */
    private static void testCowaitStack() throws InterruptedException{
        StampedLock sl = new StampedLock();
//        long stamp = sl.writeLock();
        // 先让T0线程去排队到尾节点
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                long stamp = sl.readLock();
                System.out.println(Thread.currentThread().getName()+ " stamp: " + stamp );
            }
        },"T0").start();

        // 之后T1线程来获取读
        TimeUnit.SECONDS.sleep(3);
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                long stamp = sl.readLock();
                System.out.println(Thread.currentThread().getName()+ " stamp: " + stamp );
            }
        },"T1").start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                long stamp = sl.readLock();
                System.out.println(Thread.currentThread().getName()+ " stamp: " + stamp );
            }
        },"T2").start();
        // 在这里先断点，进入到这里后，再到源码位置去断点，就可以看到如下图的情况了
        TimeUnit.SECONDS.sleep(3);
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                long stamp = sl.readLock();
                System.out.println(Thread.currentThread().getName()+ " stamp: " + stamp );
            }
        },"T3").start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("准备释放写锁");
//        sl.unlockWrite(stamp);
        System.out.println("释放了写锁");
    }
}
