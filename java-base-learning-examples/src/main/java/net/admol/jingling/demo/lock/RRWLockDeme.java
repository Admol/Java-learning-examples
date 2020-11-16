package net.admol.jingling.demo.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : admol
 * @Date : 2020/11/11
 */
public class RRWLockDeme{
    /**
     * Ensure that a release propagates, even if there are other
     * in-progress acquires/releases.  This proceeds in the usual
     * way of trying to unparkSuccessor of head if it needs
     * signal. But if it does not, status is set to PROPAGATE to
     * ensure that upon release, propagation continues.
     * Additionally, we must loop in case a new node is added
     * while we are doing this. Also, unlike other uses of
     * unparkSuccessor, we need to know if CAS to reset status
     * fails, if so rechecking.
     */
    public static void main(String[] args) throws InterruptedException{

        Thread.currentThread().setName("TTTTTTTTTTT");
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock writeLock = lock.writeLock();
        Lock readLock = lock.readLock();
        readLock.lock();
        writeLock.lock();
        System.out.println("readLock");
//        writeLock.lock();
//        writeLock.unlock();
//        writeLock.unlock();
//        writeLock.unlock();
        new Thread(new Runnable(){
            @Override
            public void run(){
                writeLock.lock();
                System.out.println("写锁");
            }
        }).start();
//        TimeUnit.SECONDS.sleep(3);
//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                readLock.lock();
//            }
//        }).start();
    }


    private void lock(){
        ReentrantLock lock = new ReentrantLock();
        // 测试中断线程后，线程是否还能获得锁，执行逻辑代码
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                lock.lock();
                System.out.println(Thread.currentThread().getName()+": 获得了锁");
                // T1睡5秒后再解锁，这个期间来获得锁的线程都要排队
                TimeUnit.SECONDS.sleep(5);
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+": 释放了锁");
            }
        },"T1").start();
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                // 1秒后去尝试获得锁，让前面那个T1线程先获得锁，这样这个T2线程进来肯定只能排队
                TimeUnit.SECONDS.sleep(1);
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+": 获得了锁");
                    System.out.println(Thread.currentThread().getName()+": 准备中断自己");
                    TimeUnit.SECONDS.sleep(1);
                    Thread.currentThread().interrupt();
                    //                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+": 执行了中断后的代码");
                }finally{
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+": 执行了解锁");
                }
            }
        },"T2").start();
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                // 2秒后去尝试获得锁，让前面那个T1线程先获得锁，这样这个T3线程进来肯定只能排队
                TimeUnit.SECONDS.sleep(2);
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+": 获得了锁");
                    System.out.println(Thread.currentThread().getName()+": 准备中断自己");
                    TimeUnit.SECONDS.sleep(1);
                    Thread.currentThread().interrupt();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+": 执行了中断后的代码");
                }finally{
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+": 执行了解锁");
                }
            }
        },"T3").start();

    }
}
