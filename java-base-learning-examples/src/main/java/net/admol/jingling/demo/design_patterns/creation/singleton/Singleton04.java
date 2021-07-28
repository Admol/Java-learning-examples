package net.admol.jingling.demo.design_patterns.creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 04.静态内部类
 * 特点：1.线程安全（JVM特性保证） 2.支持延迟加载
 * @author : jingling
 * @Date : 2021/7/28
 */
public class Singleton04{

    private AtomicLong id = new AtomicLong(0);


    private Singleton04(){}

    private static class SingletonHolder{
        private static final Singleton04 INSTANCE = new Singleton04();
    }
    /**
     * 通过静态内部类获取初始化实例
     * @return
     */
    public static Singleton04 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public long nextId(){
        return id.incrementAndGet();
    }

}
