package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author : admol
 * @Date : 2020/6/30
 */
public class Lc0203{
    /**
     * 核心思想是虚拟一个哨兵节点, 最后返回的时候返回哨兵的下一节点
     * 时间复杂度：O(N)，只遍历了一次。
     * 空间复杂度：O(1)。
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head,int val) {
        // 1.初始化一个哨兵节点
        ListNode sentinel = new ListNode(0);
        // 2.哨兵节点指向我们的入参节点
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode cur = sentinel.next;
        while(cur !=null){
            if(cur.val == val){
                // 删除当前节点
                pre.next = cur.next;
            }else {
                // 前置节点后移
                pre = pre.next;
            }
            // 遍历下一节点
            cur = cur.next;
        }
        return sentinel.next;

    }
    /**
     * 单独处理前置节点为空的情况
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head,int val) {
        // 记录前置节点
        ListNode pre = null;
        // 遍历当前节点
        ListNode node = head;
        while(node != null){
            // 判断当前节点的值与目标值
            if(node.val == val){
                if(pre == null){
                    // pre == null 代表删除的是头结点
                    node = node.next;
                    head = node;
                    continue;
                }
                // 删除当前节点: 前置节点的下一节点=当前节点的下一节点
                pre.next = node.next;
            }else {
                // 前置节点改为当前节点
                pre = node;
            }
            // 继续判断下一节点
            node = node.next;
        }
        return head;
    }


    public static void main(String[] args){
        ListNode node = new ListNode(1,new ListNode(2, new ListNode(6,new ListNode(3))));
        System.out.println(removeElements(node,6));
        ListNode node1 = new ListNode(1,new ListNode(1,null));
        System.out.println(removeElements(node1,1));
    }
}
