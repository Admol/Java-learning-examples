package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.ListNode;

import java.util.Stack;

/**
 * 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * @author : admol
 * @Date : 2020/7/1
 */
public class Lc0206{
    /**
     * 迭代: 1-> 2-> 3-> 4
     * 初始化新链表result 0:
     * 第一步: 截取原链表节点:1, 原链表为:2->3->4 , 新链表result: 0->1
     * 第二步: 截取原链表节点:2, 原链表为:3->4 , 新链表result: 0->2->1
     * 第三步: 截取原链表节点:3, 原链表为:4 , 新链表result: 0->3->2->1
     * 第四步: 截取原链表节点:4, 原链表为:null , 新链表result: 0->4->3->2->1
     * 返回result.next;
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 用新链表接收反转后的链表
        ListNode res = new ListNode(0);
        while(head != null){
            // 1.每次取原链表的头结点
            ListNode node = head;
            if(node != null){
                head = head.next;
                // 切断, 只取一个节点, 不需要整个链表
                node.next = null;
            }
            // 2.原头结点指向新链表下面关联的节点
            node.next = res.next;
            // 3.然后将反转后的节点放到新的链表下
            res.next = node;
        }
        return res.next;
    }

    /**
     * 递归写法:
     * 时间复杂度：O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)。
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 例如: 1->2->3->4->null
        // 相当于从后面往前面遍历, 改变指向
        // 先递归调用reverseList(head.next); 触发终止条件找到尾节点4, 尾节点4会作为以后的头结点cur,每次都是返回的这个节点
        ListNode cur = reverseList3(head.next);
        // 第一次cur返回的是4->null这个链表关系, 此时head代表的链表是:3->4->null, head.next.next = head;
        // 翻译一下就是3.next.next = 3; 等于4.next = 3; 相当于把原链表3->4的指向翻转一下, 变成4->3
        head.next.next = head;
        // 链表关系变成4->3后, 因为原链表3->4的关系还存在, 会变成一个环, 所以必须把原来的关系给切断, 3.next = null;这样就只剩下4->3的关系了
        head.next = null;
        // 返回原链表的尾节点4
        return cur;
    }

    /**
     * 官方迭代写法
     * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        // 最开始前置节点为空
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // nextTemp相当于每次把头结点去掉
            ListNode nextTemp = curr.next;
            // 当前节点指向前置节点
            curr.next = prev;
            // prev作为反转后的节点
            prev = curr;
            // 原链表去掉头结点后的链表
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 用栈来存储单个节点
     * 入栈, 再出栈
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node  = head;
        while(node != null){
            stack.add(new ListNode(node.val));
            node = node.next;
        }
        ListNode res = new ListNode(0);
        node = res;
        while(!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        return res.next;
    }

    public static void main(String[] args){
        System.out.println(reverseList2(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))))));
        System.out.println(reverseList3(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))))));
    }
}
