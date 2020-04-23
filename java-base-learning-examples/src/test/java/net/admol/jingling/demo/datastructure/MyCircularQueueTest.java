package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.queue.MyCircularQueue;

/**
 * @author : admol
 * @Date : 2019/11/12
 */
public class MyCircularQueueTest{

    public static void main(String[] args){
        MyCircularQueue<Integer> queue = new MyCircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        queue.enqueue(6);
        queue.printQueue();
        queue.enqueue(7);
        queue.printQueue();
        System.out.println("出队列操作:"+queue.dequeue());
        queue.printQueue();
        queue.enqueue(8);
        queue.printQueue();
        System.out.println("出队列操作:"+queue.dequeue());
        queue.printQueue();
        queue.enqueue(9);
        queue.printQueue();
    }
}
