package net.admol.jingling.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : jingling
 * @Date : 2018/1/3
 */
public class TestSynchronized {

    static  final  ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{

        NotSafeCount count = new NotSafeCount();
        for (int i=0 ;i<50;i++){
            Thread thread1 = new TestNotSafeThread("t1",count);
            thread1.start();
        }
        SafeCount safeCount = new SafeCount();
        for (int i=0 ;i<5;i++){
            Thread thread11 = new TestSafeThread("t"+i,safeCount);
            thread11.start();
        }
        // 等活干完
        Thread.sleep(5000L);
        System.out.println("线程不安全的值: "+count.count);
        System.out.println("线程安全的值: "+safeCount.count);
    }



    static class TestNotSafeThread extends Thread{
        private NotSafeCount count;
        public TestNotSafeThread(String name, NotSafeCount count) {
            super(name);
            this.count = count;
        }
        @Override
        public void run() {
            count.add();
        }
    }

    static class TestSafeThread extends Thread{
        private SafeCount count;
        public TestSafeThread(String name, SafeCount count) {
            super(name);
            this.count = count;
        }
        @Override
        public void run() {
            count.add();
        }
    }

    static class NotSafeCount {
        private int count = 0;
        public void add() {
            lock.lock();
            try {
                Thread.sleep(61L);
                count ++;
                System.out.println("count:"+count);
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }


    static class SafeCount {
        private int count = 0;
        public synchronized void add(){
//            synchronized (SafeCount.class){
                lock.lock();
                try {
                    Thread.sleep(61L);
                    count += 1;
                    System.out.println("safe count:"+count);
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
//        }
    }
}
