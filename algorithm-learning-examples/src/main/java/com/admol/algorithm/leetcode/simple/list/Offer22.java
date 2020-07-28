package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * @author : admol
 * @Date : 2020/7/28
 */
public class Offer22{

    public static ListNode getKthFromEnd(ListNode head,int k) {

        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }

        node = head;
        for(int i = 0; i < count-k; i++){
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args){
        System.out.println(getKthFromEnd(new ListNode(1,new ListNode(2,new ListNode(3))),2));

    }
}
