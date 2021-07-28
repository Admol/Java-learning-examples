package net.admol.jingling.demo.design_patterns.creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 02.懒汉式
 * 特点：1.线程安全（并发度相对较低，每次都加锁） 2.支持延迟加载
 * @author : jingling
 * @Date : 2021/7/28
 */
public class Singleton02{

    private AtomicLong id = new AtomicLong(0);

    /** 懒汉，get时初始化 */
    private static Singleton02 INSTANCE  = null;

    private Singleton02(){}

    /**
     * 加锁范围太大
     * @return
     */
    public static synchronized Singleton02 getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }

    public long nextId(){
        return id.incrementAndGet();
    }

}
