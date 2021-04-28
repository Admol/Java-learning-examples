package net.admol.jingling.demo.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;

/**
 * @author : jingling
 * @Date : 2021/1/28
 */
public class Solver {
    AtomicInteger sum = new AtomicInteger(0);
    // 自己新增的一个标识，true代表所有的计算完成了
    volatile boolean done = false;
    final int N;
    final int[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;
        Worker(int row) {
            myRow = row;
        }
        @Override
        public void run() {
            while (!done()) {
                int rowSum = Arrays.stream(data[myRow]).sum();
                System.out.println("processRow(myRow):" + rowSum);
                sum.addAndGet(rowSum);
                try {
                    barrier.await();
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }
    }

    private boolean done(){
        return done;
    }

    public Solver(int[][] matrix) throws InterruptedException{
        data = matrix;
        N = matrix.length;
        Runnable barrierAction = () -> {
            System.out.println("mergeRows(...):"+sum.get());
            done = true;
        };
        barrier = new CyclicBarrier(N, barrierAction);

        List<Thread> threads = new ArrayList<Thread>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }

        // wait until done
        for (Thread thread : threads){
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int[][] matrix = {{1,2,3},{4,5,6}};
        Solver solver = new Solver(matrix);
    }
}