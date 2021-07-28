package net.admol.jingling.demo.design_patterns.creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 03.双重检测
 * 特点：1.线程安全（并发度相对较高，不再是每次都加锁） 2.支持延迟加载
 * @author : jingling
 * @Date : 2021/7/28
 */
public class Singleton03{

    private AtomicLong id = new AtomicLong(0);

    /** 懒汉，get时初始化 */
    private static volatile Singleton03 INSTANCE  = null;

    private Singleton03(){}

    /**
     * 加锁范围太大
     * @return
     */
    public static Singleton03 getInstance(){
        if(INSTANCE == null){
            // 相对于懒汉式，锁的范围更小，只有没初始化才会锁
            synchronized(Singleton03.class){
                INSTANCE = new Singleton03();
            }
        }
        return INSTANCE;
    }

    public long nextId(){
        return id.incrementAndGet();
    }

}
