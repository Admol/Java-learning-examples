package com.admol.algorithm.datastructure.stack;

/**
 * 数组实现的简单栈
 * 栈主要包含两个操作，入栈和出栈，也就是在栈顶插入一个数据和从栈顶删除数据
 * @author : jingling
 * @Date : 2018/10/15
 */
public class MyArrayStack{

    private String[] dataStack;
    /**栈中实际元素的个数*/
    private int count =0;
    /**栈大小*/
    private int size = 0;

    public MyArrayStack(int size){
        this.size = size;
        /**初始化指定大小的数组栈*/
        dataStack = new String[size];
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item){
        //1.校验栈空间是否充足
        if(count == size){
            //栈已经满了,不允许入栈操作
            return false;
        }
        dataStack[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop(){
        if(count == 0){
            //已经是空栈了
            return null;
        }
        String item = dataStack[count-1];
        count--;
        return item;
    }
}
