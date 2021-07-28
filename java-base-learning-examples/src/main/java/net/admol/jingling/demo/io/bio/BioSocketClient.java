package net.admol.jingling.demo.io.bio;

import java.util.concurrent.CountDownLatch;

/**
 * BIO 客户端
 * @author : jingling
 * @Date : 2021/7/20
 */
public class BioSocketClient{
    // 20个线程
    private static final int THREDS = 20;

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch cdl = new CountDownLatch(THREDS);
        for(int i = 0; i < THREDS; i++){
            SocketClientRequestThread requestThread = new SocketClientRequestThread(cdl,i);
            new Thread(requestThread).start();
            cdl.countDown();
        }

        synchronized(BioSocketClient.class){
            BioSocketClient.class.wait();
        }
    }
}
