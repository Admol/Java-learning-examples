package net.admol.jingling.demo.future;

import lombok.extern.slf4j.Slf4j;
import net.admol.jingling.demo.executor.ExecutorServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : jingling
 * @Date : 2018/1/8
 */
@Slf4j
public class TestFutureTask {

    public static void main(String[] args) throws Exception {
        List<String> resultList = new ArrayList<>(5);
        ExecutorService serviceUtil = ExecutorServiceUtil.getExecutorService();
        Boolean isend = false;
        MyTask myTask1 = new MyTask("任务_1");
        FutureTask<String> futureTask1 = new FutureTask<String>(myTask1);
        MyTask myTask2 = new MyTask("任务_2");
        FutureTask<String> futureTask2 = new FutureTask<String>(myTask2);
        MyTask myTask3 = new MyTask("任务_3");
        FutureTask<String> futureTask3 = new FutureTask<String>(myTask3);
        serviceUtil.submit(futureTask1);
        serviceUtil.submit(futureTask2);
        serviceUtil.submit(futureTask3);
        String result1 = futureTask1.get();
        log.info("result1:{}",result1);
        String result2 = futureTask2.get();
        log.info("result1:{}",result2);
        String result3 = futureTask3.get();
        log.info("result1:{}",result3);
        resultList.add(result1);
        resultList.add(result2);
        resultList.add(result3);
        log.info("list result:{}",resultList);

        serviceUtil.shutdown();
    }


    static class MyTask implements Callable<String> {

        private String name ;
        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            log.info("callable task doing.....");
            TimeUnit.SECONDS.sleep(1);
            return name + " task do success";
        }
    }


}
