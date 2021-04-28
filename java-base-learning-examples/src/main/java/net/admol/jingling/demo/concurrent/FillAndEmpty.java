package net.admol.jingling.demo.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author : jingling
 * @Date : 2021/1/29
 */
public class FillAndEmpty {
    Exchanger<Integer> exchanger = new Exchanger<Integer>();
    Integer initialEmptyBuffer = 1;
    Integer initialFullBuffer = 2;

     class FillingLoop implements Runnable {
        @Override
        public void run() {
            Integer currentBuffer = initialEmptyBuffer;
            try {
                while (currentBuffer != 2) {
                    Thread.currentThread().setName("T1");
                        currentBuffer = exchanger.exchange(currentBuffer);
                        //currentBuffer = exchanger.exchange(currentBuffer,5,TimeUnit.SECONDS);
                }
                System.out.println("FillingLoop:"+currentBuffer);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

     class EmptyingLoop implements Runnable {
        @Override
        public void run() {
            Integer currentBuffer = initialFullBuffer;
            try {
                Thread.currentThread().setName("T2");
//                TimeUnit.SECONDS.sleep(20);
                while (currentBuffer != 1) {
                        currentBuffer = exchanger.exchange(currentBuffer);
                }
                System.out.println("EmptyingLoop:"+currentBuffer);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void start() {
        new Thread(new FillingLoop()).start();
        new Thread(new EmptyingLoop()).start();
    }

    public static void main(String[] args){
        System.out.println(8 >>> 1);
//        FillAndEmpty f = new FillAndEmpty();
//        f.start();
    }
}