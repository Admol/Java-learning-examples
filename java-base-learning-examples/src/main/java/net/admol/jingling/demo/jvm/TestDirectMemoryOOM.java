package net.admol.jingling.demo.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -Xmx10m -XX:MaxDirectMemorySize=5M
 * @author : jingling
 * @Date : 2020/9/24
 */
public class TestDirectMemoryOOM{
    public static void main(String[] args) throws IllegalAccessException{
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        long _1M = 1024*1024;
        while(true){
            unsafe.allocateMemory(_1M);
        }
    }
}
