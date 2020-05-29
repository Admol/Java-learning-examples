package com.admol.algorithm.datastructure.linkedlist;

/**
 * 单向链表节点
 * @author : jingling
 * @Date : 2018/10/15
 */
public class SingleNode{

    /**指向的下一节点*/
    private SingleNode next;
    /**信息*/
    private Object data;

    public SingleNode(){
    }

    public SingleNode(Object data){
        this.data = data;
    }

    public SingleNode getNext(){
        return next;
    }
    public void setNext(SingleNode next){
        this.next = next;
    }
    public Object getData(){
        return data;
    }
    public void setData(Object data){
        this.data = data;
    }

    @Override
    public String toString(){
        return "SingleNode{" + "next=" + next + ", data=" + data + '}';
    }
}
