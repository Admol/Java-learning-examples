package com.admol.algorithm.leetcode.tags.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 *
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 * @author : jingling
 * @Date : 2021/5/8
 */
public class Lc1114{

    public static void main(String[] args) throws InterruptedException{
        ReentrantLock lock= new ReentrantLock();
        lock.lock();
        Condition c1 = lock.newCondition();
//        c1.await();
        c1.signal();
//        Foo_1 foo = new Foo_1();
//        Foo_2 foo = new Foo_2();
//        Foo_3 foo = new Foo_3();
        Foo_4 foo = new Foo_4();

        new Thread(()-> {
            try{
                foo.second(()-> System.out.println("second"));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try{
                foo.first(()-> System.out.println("first"));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try{
                foo.third(()-> System.out.println("third"));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }



    /**
     * 解法4：条件锁
     */
    static class Foo_4 {

        private volatile int flag = 1;
        ReentrantLock lock;
        Condition c1;
        Condition c2;
        Condition c3;

        public Foo_4() {
            lock = new ReentrantLock(true);
            c1 = lock.newCondition();
            c2 = lock.newCondition();
            c3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException{
            // printFirst.run() outputs "first". Do not change or remove this line.
            try{
                lock.lock();
                while(flag != 1){
                    c1.await();
                }
                printFirst.run();
                flag <<= 1;
                c2.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException{
            // printSecond.run() outputs "second". Do not change or remove this line.
            try{
                lock.lock();
                while(flag != 2){
                    c2.await();
                }
                printSecond.run();
                flag <<= 1;
                c3.signal();
            }finally{
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException{
            // printThird.run() outputs "third". Do not change or remove this line.
            try{
                lock.lock();
                while(flag != 4){
                    c3.await();
                }
                printThird.run();
                c1.signal();
            }finally{
                lock.unlock();
            }
        }
    }

    /**
     * 解法3：使用Semaphore信号量
     * 思路：和CountDownLatch的方案类似，只不过这里是由前一个方法来释放资源，后面的方法才可以执行
     */
    static class Foo_3 {

        // 1：实现互斥锁一样的效果
        Semaphore sp_second = new Semaphore(0,true);
        Semaphore sp_third = new Semaphore(0,true);

        public Foo_3() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sp_second.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            sp_second.acquire();
            printSecond.run();
            sp_third.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            sp_third.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }




    /**
     * 解法2：使用CountDownLatch
     * 思路：为second、third设置两个“屏障”，second方法执行需要由first方法开启，third方法执行需要由second方法开启，
     */
    static class Foo_2 {

        CountDownLatch cdl_second = new CountDownLatch(1);
        CountDownLatch cdl_third = new CountDownLatch(1);

        public Foo_2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            cdl_second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            cdl_second.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cdl_third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cdl_third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }


    /**
     * 解法1：使用volatile修饰的变量，来标识每个方法的执行情况
     * 优点：代码改动少
     * 缺点：second、third使用while自旋，会占用CPU，如果方法first不执行，则后面的方法会一直占用 CPU
     */
    static class Foo_1 {

        private volatile int index = 0;

        public Foo_1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            index = 1;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while(index < 1){

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            index = 2;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while(index < 2){

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

// 默认的类：
//    class Foo {
//
//        public Foo() {
//
//        }
//
//        public void first(Runnable printFirst) throws InterruptedException {
//
//            // printFirst.run() outputs "first". Do not change or remove this line.
//            printFirst.run();
//        }
//
//        public void second(Runnable printSecond) throws InterruptedException {
//
//            // printSecond.run() outputs "second". Do not change or remove this line.
//            printSecond.run();
//        }
//
//        public void third(Runnable printThird) throws InterruptedException {
//
//            // printThird.run() outputs "third". Do not change or remove this line.
//            printThird.run();
//        }
//    }
}
