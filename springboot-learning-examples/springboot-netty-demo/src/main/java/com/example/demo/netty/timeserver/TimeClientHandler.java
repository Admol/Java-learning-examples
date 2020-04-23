package com.example.demo.netty.timeserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author : jingling
 * @Date : 2018/4/17
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
//    private final ByteBuf firstMessage;
//
//    public TimeClientHandler() {
//        byte[] req = "QT".getBytes();
//        firstMessage = Unpooled.buffer(req.length);
//        firstMessage.writeBytes(req);
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送消息给服务端
        for (int i=0;i<10;i++){
            byte[] req = "QT".getBytes();
            ByteBuf firstMessage = Unpooled.buffer(req.length);
            firstMessage.writeBytes(req);
            ctx.writeAndFlush(firstMessage);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收服务端返回的消息
//        ByteBuf byteBuf = (ByteBuf)msg;
//        byte[] bytes = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(bytes);
//        String body = new String(bytes,"UTF-8");
        String body = (String) msg;
        System.out.println("time client boyd is :"+body);
    }
}
