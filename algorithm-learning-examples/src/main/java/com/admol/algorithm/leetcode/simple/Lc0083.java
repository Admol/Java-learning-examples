package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:    输入: 1->1->2         输出: 1->2
 * 示例 2:    输入: 1->1->1->2->3->3   输出: 1->2->3
 * @author : admol
 * @Date : 2020/6/16
 */
public class Lc0083{

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head;
        // 1.遍历整个链表
        while(next != null){
            // 当前节点的值
            int headVal = next.val;
            // 2.当前节点下一个节点
            ListNode nextNext =next.next;
            if(nextNext != null){
                int val = nextNext.val;
                // 3. 比较两个节点的值
                if(headVal == val){
                    // 4.如果重复,删掉当前节点的下一个节点
                    // 如果链表是: 1->1->1->2, 第一次的时候就是删掉第二个1, 第一个1的next重新指向第三个1就是删掉第二个1
                    next.next = nextNext.next;
                    continue;
                }
            }
            // 4.没有重复的值, 继续遍历下一个节点
            next = nextNext;
        }
        return head;
    }

    /**
     * 时间复杂度：O(n)，因为列表中的每个结点都检查一次以确定它是否重复，所以总运行时间为 O(n)O(n)，其中 nn 是列表中的结点数。
     * 空间复杂度：O(1)，没有使用额外的空间
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode next = head;
        // 1.遍历整个链表
        while(next.next != null){
           if(next.val == next.next.val){
               next.next = next.next.next;
           }else {
               next = next.next;
           }
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x,ListNode nextNode) {
            val = x;
            next = nextNode;
        }

        @Override
        public String toString(){
            return val + "->" + next ;
        }
    }

    public static void main(String[] args){
        System.out.println(deleteDuplicates(new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(3,null)))))));
    }
}
