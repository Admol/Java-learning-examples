package net.admol.jingling.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 同步计数器,
 * 场景使用:多个任务全部完成,整个任务才算完成
 * @author : jingling
 * @Date : 2018/1/4
 */
@Slf4j
public class TestCountdownLatch {

    /**
     * 模拟场景, 只有当三个程序都干完活了,整个任务才算是完成
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(3);
        log.info("main begin, count:{}",countDownLatch.getCount());
        Worker worker1 = new Worker(countDownLatch,"张三");
        Worker worker2 = new Worker(countDownLatch,"李四");
        Worker worker3 = new Worker(countDownLatch,"王武");
        worker1.start();
        worker2.start();
        worker3.start();
        // 当前计数到达0之前,await会一直阻塞
        countDownLatch.await();
        log.info("main end !!! ,count:{}" , countDownLatch.getCount());
    }

    static class Worker extends Thread{
        private CountDownLatch countDownLatch;
        private String workerName;

        public Worker(CountDownLatch countDownLatch, String workerName) {
            this.countDownLatch = countDownLatch;
            this.workerName = workerName;
        }

        @Override
        public void run() {
            try{
                log.info("worker is begin, name:{},cont:{}",workerName,countDownLatch.getCount());
                TimeUnit.SECONDS.sleep(5);
                log.info("worker is end, name:{} ,count:{}",workerName,countDownLatch.getCount());
            }catch (Exception e){
                log.error("e:{}",e);
            }finally {
                // 干完活,计数
                countDownLatch.countDown();
            }
        }
    }
}
