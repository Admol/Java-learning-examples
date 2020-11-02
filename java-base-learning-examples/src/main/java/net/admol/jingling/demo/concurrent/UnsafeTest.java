package net.admol.jingling.demo.concurrent;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : admol
 * @Date : 2020/10/28
 */
@Slf4j
public class UnsafeTest{

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
    public static void main(String[] args){
        Unsafe unsafe = reflectGetUnsafe();
        System.out.println(unsafe.addressSize());
    }
}
