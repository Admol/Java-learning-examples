package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.linkedlist.LRULinkedCache;

import java.util.Scanner;

/**
 * @author : admol
 * @Date : 2019/11/1
 */
public class LRULinkedCacheTest{

    public static void main(String[] args){
        LRULinkedCache cache = new LRULinkedCache();
        Scanner sc = new Scanner(System.in);
        while(true){
            String data = sc.next();
            System.out.println("放入数据:"+data);
            cache.put(data);
            cache.printAll();
        }
    }
}
