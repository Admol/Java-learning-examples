package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * @author : admol
 * @Date : 2020/7/28
 */
public class Offer24{
    /**
     * 同 Lc206
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode curr = head;
        while(curr != null){
            // 1.每次取一个节点插入到结果链表的头结点
            ListNode one = curr;
            curr = curr.next;
            one.next = ans.next;
            ans.next = one;
        }
        return ans.next;
    }

    public static void main(String[] args){
        System.out.println(reverseList(new ListNode(1,new ListNode(2,new ListNode(3)))));
    }
}
