package com.admol.algorithm.datastructure.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存
 * 当添加缓存数据的时候,
 * 如果缓存数据之前已经存在了, 则删除之前的缓存数据
 * 如果缓存数据不存在, 且缓存已经满了, 需要删除尾节点
 * 最后将缓存数据放到链表的头节点
 * 1.时间复杂度O(n)
 * 2.空间复杂度O(n)
 * @author : admol
 * @Date : 2019/11/6
 */
public class LRUArrayCache<T>{
    /**缓存数组数据*/
    private T[] data;
    /**默认容量*/
    private static final int DEFAULT_CAPACITY = (1 << 3);
    /**容量*/
    private int capacity;
    /**实际大小*/
    private int count;
    /**数据索引散列表*/
    private Map<T,Integer> holder;

    public LRUArrayCache() {
        this(DEFAULT_CAPACITY);
    }
    public LRUArrayCache(int capacity){
        this.capacity = capacity;
        // 初始化数组
        data =  (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    /**
     * 添加数据
     * @param object
     */
    public void add(T object){
        if(object == null){
            throw  new IllegalArgumentException("不支持缓存null数据");
        }
        //从散列表中查找索引
        Integer index = holder.get(object);
        if(index != null){
            // 更新缓存
            updateCache(index);
        }else{
            //不存在, 则直接缓存数据
            if(isFull()){
                removeLast();
            }
            cacheHead(object,count);
        }

    }

    private void removeLast(){
        count--;
        //移除索引
        holder.remove(data[count]);
    }

    /**
     * 更新缓存, 将第index个索引的缓存放到头部.
     * 然后右移数据
     * @param index
     */
    private void updateCache(Integer index){
        T object = data[index];
        rightShift(index);
        // 放到头部
        data[0] = object;
        // 更新索引
        holder.put(object,0);
    }

    /**
     * 缓存数组是否已经满了
     * @return
     */
    private boolean isFull(){
        return  count == capacity;
    }

    /**
     * 缓存数据到头部
     * @param object
     * @param end 要右移的数组数据右边界
     */
    private void cacheHead(T object,int end){
        // 将数组中原有缓存的数据都右移
        rightShift(end);
        // 将数据放到头部
        data[0] = object;
        // 存缓存数据的索引
        holder.put(object,0);
        // 实际缓存数据+1
        count++;
    }

    private void rightShift(int end){
        for(int i = end -1;i>=0;i--){
            // 数据右移
            data[i+1] = data[i];
            // 更新索引
            holder.put(data[i],i+1);
        }
    }


    public void printAll(){

        for(T object:data){
            System.out.print(String.valueOf(object) + "  ");
        }
        System.out.println("索引size:"+holder.size());
    }
}
