package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.queue.MyArrayQueue;
import org.junit.Test;

/**
 * @author : jingling
 * @Date : 2018/10/12
 */
public class QueueTest{

    @Test
    public void testArrayQueue(){
        MyArrayQueue myArryQueue = new MyArrayQueue(10);
        myArryQueue.enqueue("A");
        myArryQueue.enqueue("B");
        myArryQueue.enqueue("C");
        myArryQueue.printQueue();
        String item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        myArryQueue.enqueue("D");
        myArryQueue.enqueue("E");
        myArryQueue.enqueue("F");
        myArryQueue.enqueue("G");
        myArryQueue.enqueue("H");
        myArryQueue.enqueue("I");
        myArryQueue.enqueue("J");
        myArryQueue.enqueue("K");
        boolean result = myArryQueue.enqueue("L");
        myArryQueue.printQueue();
        System.out.println(result);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        item = myArryQueue.dequeue();
        System.out.println("出队列数据item:"+item);
        myArryQueue.printQueue();
    }


}
