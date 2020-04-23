package net.admol.jingling.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : jingling
 * @Date : 2018/1/4
 */
public class TestBlockingQueue {

    public static void main(String[] args)  throws  Exception{
        final BlockingQueue<String> queue = new ArrayBlockingQueue(16);
        for (int i=0; i<1; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try{
                            String log = queue.remove();
                            parseLog(log);
                        }catch (Exception e){
                        }
                    }
                }
            }).start();
        }

        for (int i=0 ; i < 16 ;i++){
            String log =   i + 1 + "  -->  ";
            queue.put(log);
        }
    }

    public static void parseLog (String log) throws  Exception{
        System.out.println(log + System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(1);
    }
}
