package net.admol.jingling.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : jingling
 * @Date : 2018/3/20
 */
public class TestVolatile {
    static double b = 0 ;
    static double a = 0 ;

    static void addA(){
        a++;
    }
    static void addB(){
        b++;
    }

    public static void main(String[] args) throws Exception{


        for (int i=0;i<5;i++){
            new Thread(){
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        addA();
                    }
                }
            }.start();
        }
        for (int i=0;i<6;i++){
            new Thread(){
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        addB();
                    }
                }
            }.start();
        }
        TimeUnit.SECONDS.sleep(15);
        System.out.println(b);
        System.out.println(a);
    }
}
