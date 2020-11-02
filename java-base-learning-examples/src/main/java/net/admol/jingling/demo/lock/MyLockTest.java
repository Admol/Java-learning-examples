package net.admol.jingling.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author : jingling
 * @Date : 2020/10/29
 */
public class MyLockTest{
    private static int noLockValue;
    private static int myLockValue;

    public static void main(String[] args) throws InterruptedException{
//        testGetLock();
//        noLockTest();
        myLockTest();
        Thread.sleep(15000);
        System.out.println("myLockValue:"+myLockValue);
//        System.out.println("noLockValue:"+noLockValue);
    }

    private static void testGetLock(){
        MyLock myLock = new MyLock();
        myLock.lock();
        System.out.println("main get locked!");
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("thread begin get lock!");
                myLock.lock();
                System.out.println("thread get locked!");
            }
        },"subThread").start();
    }

    private static void myLockTest() throws InterruptedException{
        MyLock myLock = new MyLock();
        for(int i=0;i<5;i++){
            new Thread(new Runnable(){

                @Override
                public void run(){
                    myLock.lock();
                    try{
                        IntStream.range(0,1000).forEach(i->{
                            myLockValue++;
                        });
                    }finally{
                        System.out.println(Thread.currentThread().getName() + ": "+myLockValue);
                        myLock.unlock();
                    }
                }
            },"t"+i).start();
//            TimeUnit.SECONDS.sleep(i*1+3);
        }
    }

    private static void noLockTest(){
        for(int i=0;i<5;i++){
            new Thread(new Runnable(){
                @Override
                public void run(){
                    IntStream.range(0,1000).forEach(i->{
                        noLockValue++;
                    });
                }
            }).start();
        }
    }
}
