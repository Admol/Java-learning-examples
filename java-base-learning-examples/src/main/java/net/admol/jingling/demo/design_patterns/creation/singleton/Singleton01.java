package net.admol.jingling.demo.design_patterns.creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 01.饿汉式
 * 特点：1.线程安全 2.不支持延迟加载
 * @author : jingling
 * @Date : 2021/7/28
 */
public class Singleton01{

    private AtomicLong id = new AtomicLong(0);

    /**饿汉，直接初始化*/
    private final static Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){
        return INSTANCE;
    }
    public long nextId(){
        return id.incrementAndGet();
    }

}
