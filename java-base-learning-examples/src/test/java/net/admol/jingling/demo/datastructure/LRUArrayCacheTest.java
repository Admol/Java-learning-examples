package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.stack.LRUArrayCache;

import java.util.Scanner;

/**
 * @author : admol
 * @Date : 2019/11/7
 */
public class LRUArrayCacheTest{

    public static void main(String[] args){
        LRUArrayCache cache = new LRUArrayCache();
        Scanner sc = new Scanner(System.in);
        while(true){
            String data = sc.next();
            System.out.println("放入数据:"+data);
            cache.add(data);
            cache.printAll();
        }
    }
}
