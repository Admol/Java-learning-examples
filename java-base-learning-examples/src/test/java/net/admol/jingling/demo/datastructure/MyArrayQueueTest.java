package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.queue.MyArrayQueue;

/**
 * @author : admol
 * @Date : 2019/11/12
 */
public class MyArrayQueueTest{

    public static void main(String[] args){
        MyArrayQueue queue = new MyArrayQueue(5);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.printQueue();
        queue.enqueue( "6");
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue( "7");
        queue.printQueue();
        queue.enqueue( "8");
        queue.printQueue();
    }
}
