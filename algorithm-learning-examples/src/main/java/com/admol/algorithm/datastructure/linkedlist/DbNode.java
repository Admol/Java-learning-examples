package com.admol.algorithm.datastructure.linkedlist;

/**
 * @author : jingling
 * @Date : 2018/10/15
 */
public class DbNode{
    /**指向的下一节点*/
    private DbNode next;
    /**指向的上一节点*/
    private DbNode pre;
    /**信息*/
    private Object data;

    public DbNode(){
    }

    public DbNode(Object data){
        this.data = data;
    }

    public DbNode getNext(){
        return next;
    }

    public void setNext(DbNode next){
        this.next = next;
    }

    public DbNode getPre(){
        return pre;
    }

    public void setPre(DbNode pre){
        this.pre = pre;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }
}
