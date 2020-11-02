package net.admol.jingling.demo.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 自己写的一个简单Lock
 * @author : admol
 * @Date : 2020/10/29
 */
public class MyLock{
    /** 锁标识，0：表示没有线程获得锁 */
    private volatile int state;
    /** 排队获取锁的线程列表队头 */
    private transient volatile Node head;
    /** 排队获取锁的线程列表队尾 */
    private transient volatile Node tail;
    /** state 的偏移量 */
    private static volatile long stateOffset = 0;
    /** head 的偏移量 */
    private static long headOffset;
    /** tail 的偏移量 */
    private static long tailOffset;

    private static Unsafe unsafe;

    static {
        Field field = null;
        try{
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("tail"));
        }catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }


    /**
     * 获取锁
     */
    public void lock(){
        // 1.使用cas方式修改state值为1，成功修改则代表获得锁
        if(compareAndSetState(0,1)){
            System.out.println(Thread.currentThread().getName()+" lock");
            return;
        }
        // 进入到这里，说明已经有线程获得了锁，新的现在需要排队
        // 2.当前线程排队入队
        Node curr = enqueue(new Node(Thread.currentThread()));
//        System.out.println("入队后当前节点curr:"+curr+"   头结点head:"+head + " 尾节点tail:"+tail);
        // 3.再次尝试获得锁
        while(!compareAndSetState(0,1)){
            // 没有获取到锁，阻塞线程
            System.out.println(Thread.currentThread().getName()+" park");
            unsafe.park(false,0L);
        }
        System.out.println(Thread.currentThread().getName() +  " 获得锁------ curr:"+curr);
        // 4.当前线程获取到了锁，更新head节点
        head = curr;
//        curr.thread = null;
        curr.prev = null;
    }

    /**
     * 解锁
     */
    public void unlock(){
        // 解锁和加锁理论上应该成对使用，所以这里修改state不需要再次加锁
        state = 0;
        System.out.println(Thread.currentThread().getName()+"解锁时头结点head:"+head + " 尾节点tail:"+tail);
        // 唤醒下一个线程
        if(head != null){
            System.out.println(Thread.currentThread().getName()+" unpark " + head.thread.getName());
            unsafe.unpark(head.thread);
            System.out.println(" unpark " + head.thread.getName() + "时 ，head 节点："+head);
            head = head.next;
            System.out.println(" 修改头结点后 " + Thread.currentThread().getName() + "，head 节点："+head);

        }
    }

    /**
     * 排队入队,加入到尾节点
     * @return
     */
    private Node enqueue(Node node){
        // 自旋入队，直到成功为止
        while(true){
            Node t = tail;
            if(t == null){
                // 尾节点还未初始化
                // CAS 设置头结点，并更新尾节点
                if(compareAndSetHead(node)){
//                    System.out.println("head:"+head);
                    tail = node;
                    return node;
                }
            }else{
                node.prev = t;
                // 尝试更新尾节点
                if (compareAndSetTail(t, node)){
                    t.next = node;
//                    System.out.println("node:"+node+"        tail:"+tail+"   head："+head);
                    return node;
                }
            }
        }
    }

//    public static void main(String[] args){
//        for(Integer integer : Arrays.asList(1,2,3,4,5)){
//            Node node = new Node(integer);
//            Node t = tail;
//            if(t == null){
//                head = node;
//                System.out.println("head:"+head);
//                tail = head;
//            }else{
//                node.prev = t;
//                // 尝试更新尾节点
//                tail = node;
//                t.next = node;
////                if (compareAndSetTail(t, node)){
//                    System.out.println("        tail:"+tail+"   head"+head);
////                    t.next = node;
////                }
//            }
//        }
//    }
    private boolean compareAndSetTail(Node expected,Node update){
        return unsafe.compareAndSwapObject(this,tailOffset,expected,update);
    }

    private boolean compareAndSetHead(Node newHead){
        return unsafe.compareAndSwapObject(this,headOffset,null,newHead);
    }

    /**
     * 采用 unsafe 的 CAS 方式更新state字段
     * @param expected 期望值
     * @param update 修改值
     * @return
     */
    private boolean compareAndSetState(int expected,int update){
        return unsafe.compareAndSwapInt(this,stateOffset,expected,update);
    }


    @Getter
    @AllArgsConstructor
    static class Node{
        private Thread thread;
        private int tag;
        private Node prev;
        private Node next;

        Node(Thread thread){
            this.thread = thread;
        }
        Node(int tag){
            this.tag = tag;
        }

        @Override
        public String toString(){
            return "Node{" + "thread=" + thread.getName() + ", next=" + next + '}';
        }
    }
}
