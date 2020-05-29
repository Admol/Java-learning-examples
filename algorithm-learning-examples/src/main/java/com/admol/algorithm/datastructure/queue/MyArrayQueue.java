package com.admol.algorithm.datastructure.queue;

/**
 * 数组实现的简单队列
 * 入队时间复杂度: 0(1)
 * 出队时间复杂度: 0(1)
 * @author : jingling
 * @Date : 2018/10/12
 */
public class MyArrayQueue{

    /**数据数组*/
    private String dataArray[];
    /**队列数据实际长度*/
    private int capacity = 0;
    /**head 指针，指向队头*/
    private int head = 0;
    /**tail 指针，指向队尾*/
    private int tail = 0;

    /**初始化队列的长度*/
    public MyArrayQueue(int length){
        this.dataArray = new String[length];
        this.capacity = length;
    }
    /**
     * 加入队列
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        //1.校验队列是否已经满了
        if(tail == capacity){
            if(head == 0){
                // 队头还在第一个
                return false;
            }
            // 数据迁移, 从head-tail 迁移到0, tail-head-1
            for(int i=head;i<tail;i++){
                dataArray[i-head] = dataArray[i];
            }
            // 重置队尾和队头的指针
            tail = tail - head;
            head = 0;

        }
        dataArray[tail] = item;
        //队列尾巴往后移
        tail++;
        return true;
    }

    /**
     * 出队列
     * @return
     */
    public String dequeue(){
        //空队列
        if(head == tail){
            return null;
        }
        String item = dataArray[head];
        dataArray[head] = null;
        // 移动head指针
        head++;
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
}
