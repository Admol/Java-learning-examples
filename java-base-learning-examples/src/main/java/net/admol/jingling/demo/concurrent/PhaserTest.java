package net.admol.jingling.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Phaser 使用示例
 * Phaser 是 JDK 1.7 开始提供的一个可重复使用的同步屏障，功能类似于 CyclicBarrier和CountDownLatch，但使用更灵活，支持对任务的动态调整，并支持分层结构来达到更高的吞吐量。
 * @author : jingling
 * @Date : 2021/2/3
 */
public class PhaserTest{

    public static void main(String[] args) throws InterruptedException{
        PhaserTest test = new PhaserTest();
//        test.start();
        test.runTasks2();
    }

    private void start() throws InterruptedException{
        ArrayList<Runnable> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(new MyTask(i));
        }
        runTasks(list);
    }

    /**
     * 代替 CountDownLatch
     * @param tasks
     */
     void runTasks(List<Runnable> tasks) throws InterruptedException{
        // "1" to register self
        final Phaser phaser = new Phaser(1);
        // create and start threads
        for (final Runnable task : tasks) {
            phaser.register();
            new Thread() {
                @Override
                public void run() {
                    // await all creation
                    // 类似 CountDownLatch.await() 和  CyclicBarrier.await()
                    System.out.println("等待所有的任务+1");
                    phaser.arriveAndAwaitAdvance();
                    task.run();
                }
            }.start();
        }

        // allow threads to start and deregister self
         TimeUnit.SECONDS.sleep(1);
        System.out.println("jinglingwang.cn 放行。。。。。。");
        // 类似 CountDownLatch.countDown() 减到了0 和 CyclicBarrier 中的最后一个线程调用了await()
        phaser.arriveAndDeregister();
    }


    void runTasks2() {
         // 定义阶段数
         int phases = 2;
         // 进入下一个阶段需要的参与数（线程数）
         int parties = 2;
         // 自定义onAdvance
//        Phaser phaser = new Phaser(parties);
         Phaser phaser = new Phaser(parties){
             @Override
             protected boolean onAdvance(int phase,int registeredParties){
                 System.out.println("阶段phase: "+(phase +1) +" 执行完毕");
                 return phase > phases || registeredParties ==0;
             }
         };
        for(int i = 1; i <= parties; i++){
            new Thread(()->{
                for(int j = 1; j <= phases; j++){
                    System.out.println(Thread.currentThread().getName() + " doing 阶段："+ j + " ---phaser:" + phaser.arriveAndAwaitAdvance());
                }
            },"Thread-"+i).start();

        }
    }


     class MyTask implements Runnable{

        private int data;

        public MyTask(int data){
            this.data = data;
        }

        @Override
        public void run(){
            System.out.println("task data:"+data);
        }
    }
}
