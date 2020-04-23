package net.admol.jingling.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author : jingling
 * @Date : 2018/1/8
 */
@Slf4j
public class TestForkJoin {

    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,100);
        Future<Integer> future = forkJoinPool.submit(countTask);
        log.info("result:{}" , future.get());
    }
    static class CountTask extends RecursiveTask<Integer> {

        private int start,end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        protected Integer compute() {
            int sum = 0;
            log.info("start:{},end:{}" ,start,end);
            boolean can = (end -start) <= 10;
            //是否到了最新的分割任务
            if(can){
                for (int i = start;i<=end;i++){
                    sum = sum + i;
                }
            }else{
                int mid = (start + end )/ 2 ;
                log.info("mid:{}" ,mid);
                //分割成2个任务
                CountTask task1 = new CountTask(start,mid);
                CountTask task2 = new CountTask(mid+1,end);
                task1.fork();
                task2.fork();

                int sum1 = task1.join();
                int sum2 = task2.join();
                sum = sum1 + sum2;
            }
            return sum;
        }
    }
}
