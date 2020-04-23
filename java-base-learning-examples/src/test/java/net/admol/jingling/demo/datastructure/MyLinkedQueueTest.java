package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.queue.MyLinkedQueue;

/**
 * @author : admol
 * @Date : 2019/11/12
 */
public class MyLinkedQueueTest{
    public static void main(String[] args){
        MyLinkedQueue<String> queue = new MyLinkedQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.printAll();
        System.out.println("出队列:"+queue.dequeue());
        System.out.println("出队列:"+queue.dequeue());
        System.out.println("出队列:"+queue.dequeue());
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.printAll();

    }
}
