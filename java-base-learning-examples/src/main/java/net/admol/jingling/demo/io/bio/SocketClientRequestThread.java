package net.admol.jingling.demo.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 * 客户端请求线程
 * @author : jingling
 * @Date : 2021/7/20
 */
@Slf4j
public class SocketClientRequestThread implements Runnable {

    private CountDownLatch ctl;

    private Integer index;

    public SocketClientRequestThread(CountDownLatch ctl,Integer index){
        this.ctl = ctl;
        this.index = index;
    }

    @Override
    public void run(){
        Socket socket = null;
        OutputStream clientRequest = null;
        InputStream clientResponse = null;
        try {
            socket = new Socket("localhost",83);
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();

            //等待，直到SocketClientDaemon完成所有线程的启动，然后所有线程一起发送请求
            this.ctl.await();

            //发送请求信息
            clientRequest.write(("这是第" + this.index + " 个客户端的请求。").getBytes());
            clientRequest.flush();

            //在这里等待，直到服务器返回信息
            log.info("第" + this.index + "个客户端的请求发送完成，等待服务器返回信息");
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int realLen;
            String message = "";
            //程序执行到这里，会一直等待服务器返回信息(注意，前提是in和out都不能close，如果close了就收不到服务器的反馈了)
            while((realLen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
                message += new String(contextBytes , 0 , realLen);
            }
            log.info("接收到来自服务器的信息:" + message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if(clientRequest != null) {
                    clientRequest.close();
                }
                if(clientResponse != null) {
                    clientResponse.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
