package net.admol.jingling.demo.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : jingling
 * @Date : 2021/6/9
 */
public class TestCopyOnWriteArrayList{

    public static void main(String[] args){
       new TestCopyOnWriteArrayList().consistency();
    }

    /**
     * CopyOnWriteArrayList 弱一致性测试
     */
    public void consistency(){
        CopyOnWriteArrayList cowArray = new CopyOnWriteArrayList();
        cowArray.add(1);
        cowArray.add(2);
        cowArray.add(3);
        cowArray.add(4);
        Iterator it = cowArray.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+ " ");
        }
        cowArray.add("jinglingwang.cn");
        if(it.hasNext()){
            // 不会输出 jinglingwang.cn
            System.out.print(it.next()+ " ");
        }
    }
}
