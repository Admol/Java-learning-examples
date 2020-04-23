package net.admol.jingling.demo.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 * @author : jingling
 * @Date : 2018/8/30
 */
@Slf4j
public class Solution02{

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        int carry = 0;
        while((l1 != null || l2 != null) || carry > 0 ){
            listNode.next = new ListNode(0);
            listNode = listNode.next;
            if(l1 != null && l2 != null){
                listNode.val = l1.val + l2.val + carry ;
                l1 = l1.next;l2 = l2.next;
            }else if(l1 != null){
                listNode.val = l1.val + carry;
                l1 = l1.next;
            }else if(l2 != null){
                listNode.val = l2.val + carry;
                l2 = l2.next;
            }else if(carry > 0){
                listNode.val =  carry;
            }
            if(listNode.val >= 10){
                listNode.val = listNode.val -10;
                carry = 1;
            }else{
                carry = 0;
            }
        }
        return head.next;

    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1,l2);
        log.info("resilt:{}",result);
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString(){
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}
