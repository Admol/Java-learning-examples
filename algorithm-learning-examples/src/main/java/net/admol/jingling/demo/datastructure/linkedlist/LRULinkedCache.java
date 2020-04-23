package net.admol.jingling.demo.datastructure.linkedlist;


/**
 * 基于单向链表形式实现一个简单的LRU(最近最少使用)的缓存
 * 当向链表插入缓存数据的时候,
 * 如果缓存数据之前已经存在了, 则删除之前的缓存数据
 * 如果缓存数据不存在, 且缓存已经满了, 需要删除尾节点
 * 最后将缓存数据放到链表的头节点
 * 1.时间复杂度O(n)
 * 2.空间复杂度O(1)
 * @author : admol
 * @Date : 2019/11/1
 */

public class LRULinkedCache<T>{

    //缓存链表的长度
    private int length;
    //链表容量
    private int capacity = 10;
    // 头节点
    private Node<T> headNode;
    // 默认容量
    private final static Integer DEFAULT_CAPACITY = 10;

    public LRULinkedCache(){
        this.capacity = DEFAULT_CAPACITY;
        this.headNode = new Node();
    }

    /**
     * 初始化容量
     * @param capacity
     */
    public LRULinkedCache(int capacity){
        this.capacity = capacity;
        //初始化时实际链表数据长度为0
        this.length = 0;
        this.headNode = new Node();
    }

    /**
     * 添加缓存对象到链表中
     * @param data
     * @return
     */
    public void put(T data){
        // 更新操作, 需要知道前一个节点
        // 1.查找前一个节点
        Node preNode = findPreNode(data);
        if(preNode != null){
            //链表中存在, 需要删除前一个节点的下一个节点
            deleteNodeNext(preNode);
        }else{
            //链表中不存在
            if(this.length >= this.capacity){
                // 超过容量大小, 删除尾节点
                deleteLastNode();
            }
        }
        //缓存节点放在头节点, 必定会做的一个步骤
        insertHeadNode(data);
    }

    /**
     * 在链表头部插入节点
     * @param data
     */
    private void insertHeadNode(T data){
        // 头节点的下一个节点
        Node headNodeNext = headNode.getNext();
        // 初始化当前节点, 并带上头节点的下一个节点
        Node node = new Node(data,headNodeNext);
        // 头节点指向当前新的节点
        headNode.setNext(node);
        // 长度+1
        this.length++;
    }

    /**
     * 删除尾节点
     */
    private void deleteLastNode(){
        // 得到倒数第二个节点, 设置next为null, 长度-1
        Node node = headNode;
        if(node.getNext() == null){
            //空的链表
            return;
        }
        // 找倒数第二个节点
        while(node.getNext().getNext() != null){
            node = node.getNext();
        }

        // 设置next为null, 长度-1
        Node temp = node.getNext();
        temp = null;
        node.setNext(null);
        length --;
    }

    /**
     * 删除入参节点的下一个节点
     * @param preNode
     */
    private void deleteNodeNext(Node preNode){
        //获取下一个节点
        Node next = preNode.getNext();
        // 将入参节点的索引指向下下一个节点
        preNode.setNext(next.getNext());
        //链表的实际长度
        this.length--;
        next = null;
    }

    /**
     * 获取查找到元素的前一个节点
     * @param data
     * @return
     */
    private Node findPreNode(T data){
        Node node = headNode;
        //如果存在下一个指向
        while(node.getNext() != null){
            // 比较是否存在缓存
            if(data.equals(node.getNext().getData())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void printAll(){
        Node node = headNode.getNext();
        System.out.print(node+",");
        while (node != null) {
            System.out.print(node.getNext() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     *节点
     */
    class Node<T>{
        private T data;
        private Node next;

        public Node(){
            this.next = null;
        }

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }

        public Object getData(){
            return data;
        }

        public void setData(T data){
            this.data = data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        @Override
        public int hashCode(){
            return data.hashCode();
        }

        @Override
        public boolean equals(Object obj){
            return obj.equals(data);
        }

        @Override
        public String toString(){
            return "data:" + String.valueOf(data);
        }
    }
}
