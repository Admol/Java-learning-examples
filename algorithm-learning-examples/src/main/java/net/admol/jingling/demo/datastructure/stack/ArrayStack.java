package net.admol.jingling.demo.datastructure.stack;

/**
 * 基于数组实现的栈
 * 栈的特点: 先进后出
 * 空间复杂度 O(1)
 * 时间复杂度 O(1)
 * @author : admol
 * @Date : 2019/11/7
 */
public class ArrayStack<T>{

    //默认容量大小
    private static final int DEFAULT_CAPACITY = (1 << 3);
    //栈的容量大小
    private int size;
    //栈中元素个数
    private int count;
    //数组栈
    private T[] data;
    // 栈满后是否需要扩容
    private boolean expansion;

    /**
     * 初始化固定大小的栈
     * @param size
     */
    public ArrayStack(int size){
        this.size = size;
        this.data = (T[])new Object[size];
        this.count = 0;
        this.expansion = false;
    }

    public ArrayStack(boolean expansion){
        this.expansion = expansion;
        this.size = DEFAULT_CAPACITY;
        this.data = (T[])new Object[this.size];
        this.count = 0;
    }

    /**
     * 入栈操作
     * @param object
     * @return
     */
    public boolean push(T object){
        if(isFull()){
            if(expansion){
                //扩容, 重新申请数组
                size = size << 1;
                T[] newData = (T[])new Object[size];
                System.arraycopy(data,0,newData,0,count);
                data = newData;
                newData = null;
            }else{
                // 栈满, 不让进栈操作
                return false;
            }
        }
        //将数据放在count下标位置, 并+1
        data[count] = object;
        count++;
        return true;
    }

    /**
     * 出栈, 但不移除元素
     * @return
     */
    public T peek(){
        if(count < 1){
            return null;
        }
        return data[count-1];
    }
    /**
     * 出栈操作
     * @return
     */
    public T pop(){
        if(isEmpty()){
            // 空栈
            return null;
        }
        // 取出数组的最后一个元素, 也就是count索引的位置元素, 数组元素个数-1
        T result = data[--count];
        data[count] = null;
        return result;
    }

    /**
     * 栈满
     * @return
     */
    private boolean isFull(){
        return this.count == size;
    }

    /**
     * 空栈
     * @return
     */
    public boolean isEmpty(){
        return this.count == 0;
    }

    /**
     * count
     * @return
     */
    public int count(){
        return this.count;
    }

}
