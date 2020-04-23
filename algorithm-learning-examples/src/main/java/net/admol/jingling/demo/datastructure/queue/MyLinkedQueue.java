package net.admol.jingling.demo.datastructure.queue;


/**
 * 基于链表实现的简单队列
 * @author : admol
 * @Date : 2019/11/12
 */
public class MyLinkedQueue<T>{

    //队头
    private Node<T> head;
    //队尾
    private Node<T> tail;

    /**
     * 入队操作
     * @param object
     * @return
     */
    public void enqueue(T object){
        // 第一次入队
        Node newNode = new Node(object,null);
        if(tail == null){
            //初始化节点, 后续对tail.next节点的操作会同步到head
            head = newNode;
            tail = newNode;
        }else{
            // tail->next = newNode
            tail.next = newNode;
            //更新tail指针
            tail = tail.next;
        }
    }

    /**
     * 出队操作
     * @return
     */
    public T dequeue(){
        if(head == null){
            return null;
        }
        T data = head.data;
        head = head.next;
        //出队列后 队列为空
        if(head == null){
            tail = null;
        }
        return data;
    }

    public void printAll(){
        Node p = head;
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     *节点
     */
    class Node<T>{
        private T data;
        private MyLinkedQueue.Node next;

        public Node(T data,MyLinkedQueue.Node next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString(){
            return "data:" + String.valueOf(data);
        }
    }

}
