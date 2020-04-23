package net.admol.jingling.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 循环栅栏
 * 同步计数器
 * @author : jingling
 *
 * @Date : 2018/1/5
 */
@Slf4j
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TotalThread());
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i=0; i < 6 ; i++){
            TotalTask totalTask = new TotalTask(cyclicBarrier,i *2);
            totalTask.start();
        }
        log.info("main end....................");
    }
    static class TotalThread extends Thread{
        @Override
        public void run() {
            log.info("所有的子任务执行完成后,开始执行主任务....................");
        }
    }
    static class  TotalTask extends Thread{
        private CyclicBarrier cyclicBarrier;
        private int waitTime;
        public TotalTask( CyclicBarrier cyclicBarrier,int waitTime) {
            this.cyclicBarrier = cyclicBarrier;
            this.waitTime = waitTime;
        }
        @Override
        public void run() {
            log.info("子任务 name:{} 开始执行任务...........",Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(waitTime);
                log.info("子任务 name:{} 任务处理等待 waitTime:{} ,waitCount:{}...........",
                        Thread.currentThread().getName(),waitTime,cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
                log.info("子任务 name:{} 任务等待结束,继续处理后续任务...........",Thread.currentThread().getName());
            }catch (Exception e){
                log.error("异常e:{}",e);
            }
        }
    }
}
