package net.admol.jingling.demo.design_patterns.creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 05.枚举
 * 特点：1.线程安全（JVM特性保证）
 * @author : jingling
 * @Date : 2021/7/28
 */
public enum Singleton05{
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);



    public long nextId(){
        return id.incrementAndGet();
    }

}
