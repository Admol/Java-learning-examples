package com.admol.algorithm.datastructure.queue;

import java.util.HashMap;

/**
 * 基于数组实现的简单循环队列
 * 相比数组队列少了数据迁移的操作
 * 判断队列是否满的条件为: (tail + 1) % capacity == head
 * 队头队尾的指针移动不再是++操作, 而是(指针+1) % capacity
 * 会存在浪得一个tail的空间
 * @author : admol
 * @Date : 2019/11/12
 */
public class MyCircularQueue<T>{
    /**数据数组*/
    private T dataArray[];
    /**队列数据实际长度*/
    private int capacity = 0;
    /**head 指针，指向队头*/
    private int head = 0;
    /**tail 指针，指向队尾*/
    private int tail = 0;

    /**初始化队列的长度*/
    public MyCircularQueue(int length){
        this.dataArray = (T[])new Object[length];
        this.capacity = length;
    }
    /**
     * 加入队列
     * @param item
     * @return
     */
    public boolean enqueue(T item){
        //1.校验队列是否已经满了
        if((tail + 1) % capacity == head){
            return false;
        }
        dataArray[tail] = item;
        //队列尾巴往后移,队尾不再只是 tail++
        tail = (tail+1) % capacity;
        return true;
    }

    /**
     * 出队列
     * @return
     */
    public T dequeue(){
        //空队列
        if(head == tail){
            return null;
        }
        T item = dataArray[head];
        dataArray[head] = null;
        // 移动head指针,不再是 head++;
        head = (head + 1) % capacity;
        return item;
    }

    public void printQueue(){
        StringBuffer data = new StringBuffer();
        for(int i=0;i<dataArray.length;i++){
            data.append(dataArray[i]);
            data.append(",");
        }
        System.out.println("队头:"+head+" 队尾:"+tail+ "  data:"+data.toString());
    }

    public static void main(String[] args){
        int count = f(4);
        System.out.println(count);
    }

    private static int f(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        HashMap<Integer,Integer> hashMap = new HashMap();
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        int result = f(n-1) + f(n-2);
        hashMap.put(n, result);
        return result;
    }
}
