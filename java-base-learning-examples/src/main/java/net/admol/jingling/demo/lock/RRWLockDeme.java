package net.admol.jingling.demo.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

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
//        testDeadLock();
//        testWriteLockHunger();
    }

    private static void testDeadLock(){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
        Lock writeLock = lock.writeLock();
        Lock readLock = lock.readLock();
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                TimeUnit.SECONDS.sleep(1);
                // 模拟1秒后其他线程来获得读锁
                System.out.println(Thread.currentThread().getName()+":准备获得读锁");
                readLock.lock();
                System.out.println(Thread.currentThread().getName()+":最开始线程获得读锁");
                // 睡眠15秒，一直持有读锁
                readLock.unlock();
                System.out.println(Thread.currentThread().getName()+":释放了读锁");
            }
        },"T0").start();
        readLock.lock();
        System.out.println(Thread.currentThread().getName()+"：获得了读锁");
        writeLock.lock();
        System.out.println(Thread.currentThread().getName()+"：获得了写锁");
        readLock.unlock();
        System.out.println(Thread.currentThread().getName()+"：解读锁");
        writeLock.unlock();
        System.out.println(Thread.currentThread().getName()+"：解写锁");
    }
    /**
     * 测试有多个读锁在排队，一个写锁进来，是否会插前面获取读锁的队
     */
    private static void testWriteLockHunger() throws InterruptedException{
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
        Lock writeLock = lock.writeLock();
        Lock readLock = lock.readLock();
        // T0 线程先获得读锁，并持有一段时间
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                readLock.lock();
                System.out.println(Thread.currentThread().getName()+":最开始线程获得读锁");
                // 睡眠15秒，一直持有读锁
                TimeUnit.SECONDS.sleep(15);
                readLock.unlock();
                System.out.println(Thread.currentThread().getName()+":释放了读锁");
            }
        },"T0").start();
        // 1秒后其他线程再来获取锁，保证前面那个T0线程最先获得读锁
        TimeUnit.SECONDS.sleep(1);
        // TW-1 来排队获取写锁
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName()+":准备获得写锁");
                writeLock.lock();
                System.out.println(Thread.currentThread().getName()+":获得写锁");
                TimeUnit.SECONDS.sleep(5);
                writeLock.unlock();
                System.out.println(Thread.currentThread().getName()+":释放了写锁");
            }
        },"TW-1").start();
        TimeUnit.SECONDS.sleep(1);
        // 这里睡眠1秒是为了写锁排队在读锁获取的前面
        IntStream.range(1,5).forEach(i->{
            new Thread(new Runnable(){
                @SneakyThrows
                @Override
                public void run(){
                    System.out.println(Thread.currentThread().getName()+":准备获取读锁");
                    readLock.lock();
                    System.out.println(Thread.currentThread().getName()+":获取了读锁");
                    // 持有部分时间的读锁
                    TimeUnit.SECONDS.sleep(i*2);
                    readLock.unlock();
                    System.out.println(Thread.currentThread().getName()+":释放了读锁");
                }
            },"T-"+i).start();
        });
        // 最后再来个获取写锁的线程，肯定会在所有读锁的后面获取到写锁
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName()+":准备获取写锁");
                while(!writeLock.tryLock()){
                    // 一直尝试获得写锁，直到成功
                }
//                writeLock.lock();
                System.out.println(Thread.currentThread().getName()+":获取了写锁");
                // 持有部分时间的读锁
                TimeUnit.SECONDS.sleep(2);
                writeLock.unlock();
                System.out.println(Thread.currentThread().getName()+":释放了写锁");
            }
        },"TW").start();


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

    class Point {
        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double deltaX, double deltaY) { // an exclusively locked method
            // 写锁-独占资源
            long stamp = sl.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                sl.unlockWrite(stamp);
            }
        }

        double distanceFromOrigin() { // A read-only method
            // 只读的方法，比较乐观，认为读的过程中不会有写，所以这里是乐观度
            long stamp = sl.tryOptimisticRead();
            double currentX = x, currentY = y;
            if (!sl.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
                // 获取一个普通的读锁
                stamp = sl.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    // 释放读锁
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        void moveIfAtOrigin(double newX, double newY) { // upgrade
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();
            try {
                while (x == 0.0 && y == 0.0) {
                    // 普通读锁转换成写锁
                    long ws = sl.tryConvertToWriteLock(stamp);
                    if (ws != 0L) {
                        stamp = ws;
                        x = newX;
                        y = newY;
                        break;
                    }
                    else {
                        sl.unlockRead(stamp);
                        stamp = sl.writeLock();
                    }
                }
            } finally {
                sl.unlock(stamp);
            }
        }
    }
}
