package net.admol.jingling.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : jingling
 * @Date : 2021/6/17
 */
public class TestThreadPool{

    Integer a;
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(11);

        Future future = executor.submit(()->{
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("begin return ");
            return "hello!";
        });

        int a = 1;
//        System.out.println(a);
        a += setA();
//        System.out.println(a);


        for(int i = 0; i < 100; i++){
//            System.out.println("i = "+i);
            a = i;
        }


        System.out.println(a);

//        System.out.println("begin get");
//        System.out.println(future.get());
        throw new RuntimeException("111111");
    }

    private static int setA(){
        return 10;
    }
}
