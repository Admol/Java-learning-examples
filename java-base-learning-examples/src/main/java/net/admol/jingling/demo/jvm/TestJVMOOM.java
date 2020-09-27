package net.admol.jingling.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出测试
 * JVM args:
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/var/log/gc_dump.dump
 * @author : admol
 * @Date : 2020/9/24
 */
public class TestJVMOOM{
    static class OOMObejct{

    }
    public static void main(String[] args){
        List<OOMObejct> list = new ArrayList<>();
        while(true){
            list.add(new OOMObejct());
        }
    }
}
