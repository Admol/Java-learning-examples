package net.admol.jingling.demo.concurrent;

import java.util.HashMap;

/**
 * @author : jingling
 * @Date : 2021/2/5
 */
public class HashMapTest{

    public static void main(String[] args){
        Object key = "f-4";
        int h;
        System.out.println((key.hashCode()));
        System.out.println((h = key.hashCode()) ^ (h >>> 16));
        HashMap map = new HashMap<>(4);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
    }
}
