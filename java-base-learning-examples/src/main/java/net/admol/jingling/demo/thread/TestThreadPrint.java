package net.admol.jingling.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 三个线程按照顺序交替分别打印100次A、B、C
 * @author : jingling
 * @Date : 2021/1/25
 */
public class TestThreadPrint{
    volatile static int flag = 1;
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        Condition ca = lock.newCondition();
        Condition cb = lock.newCondition();
        Condition cc = lock.newCondition();

        new Thread(()->{
            IntStream.range(0,100).forEach(i->{
                // 1.0 获得锁
                lock.lock();
                try{
                    // 1.1 没到自己打印的时候
                    while(flag != 1){
                        // 1.11 等待被唤醒
                        ca.await();
                    }
                    System.out.println("A_" + i);
                    // 1.3 打印完之后准备唤醒下一个线程B
                    flag = 2;
                    cb.signal();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            });
        },"T-A").start();
        new Thread(()->{
            IntStream.range(0,100).forEach(i->{
                lock.lock();
                try{
                    // 1.1 没到自己打印的时候
                    while(flag != 2){
                        // 1.11 等待被唤醒
                        cb.await();
                    }
                    System.out.println("B_" + i);
                    // 1.3 打印完之后准备唤醒下一个线程B
                    flag = 3;
                    cc.signal();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            });
        },"T-B").start();
        new Thread(()->{
            IntStream.range(0,100).forEach(i->{
                lock.lock();
                try{
                    // 1.1 没到自己打印的时候
                    while(flag != 3){
                        // 1.11 等待被唤醒
                        cc.await();
                    }
                    System.out.println("C_" + i);
                    // 1.3 打印完之后准备唤醒下一个线程B
                    flag = 1;
                    ca.signal();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            });
        },"T-C").start();


    }
}
