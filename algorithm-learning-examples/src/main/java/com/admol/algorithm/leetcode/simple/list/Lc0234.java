package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0234{

    /**
     * 快慢指针思想
     * 1. 先利用快慢指针找到链表的中点
     * 2. 然后反转后半部分链表
     * 3. 比较反转后的链表和原链表
     * 该方法的缺点是，在并发环境下，函数运行时需要锁定其他线程或进程对链表的访问，因为在函数执执行过程中链表暂时断开。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        System.out.println("入参链表:"+head);
        // 1. 找到中间节点之后的链表
        ListNode mid = findMid(head);
        // 2. 反转中间节点后的链表
        ListNode reverse = reverse(mid);
        System.out.println("反转被破坏后的链表:"+head);
        ListNode node = head;
        ListNode two = reverse;
        boolean result = true;
        // 3. 比较两个链表
        while(result && node != null && two != null){
            if(node.val != two.val){
                // 不在这直接return, 是因为后面要恢复原链表
                result = false;
            }
            node = node.next;
            two = two.next;
        }
        // 4. 恢复原链表结构
        reverse(reverse);
        System.out.println("恢复后的链表:"+head);
        return result;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 快慢指针找链表中点
     * @param head
     * @return
     */
    private static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            // 慢指针向前走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
        }
        // 理论上快指针走到终点(null)的时候, 慢指针正好走到中点
        return slow;
    }

    /** 递归函数共用前置指针 */
    private static ListNode pre;
    /**
     * 递归
     * 思想:
     * 利用递归会先遍历到尾节点, 然后逐渐退出向上返回的时候与前置指针进行比较
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head) {
        pre = head;
        return check(head);
    }

    private static boolean check(ListNode node){
        if(node != null){
            if(!check(node.next)){
                // 递归出栈时,栈尾的每次和头结点比较的结果做判断
                return false;
            }
            // 第一次最先走到这里的代码肯定是链表的最后一个节点
            // 然后就可以和链表的第一个节点比较
            if(pre.val != node.val){
                // 首位不相等, 直接退出false
                return false;
            }
            // 相等的话, 递归向上返回一层, 头结点向后移
            pre = pre.next;
        }
        return true;
    }

    /**
     * 双指针: 利用数组顺序存储链表, 然后用双指针比较头尾节点
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        ListNode node = head;
        ArrayList<Integer> list = new ArrayList();
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            // 左指针右移
            left++;
            // 右指针左移
            right--;
        }
        return true;
    }
    /**
     * 同时入栈和入队列
     * 然后同时出栈和出队列进行比较
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            queue.add(node);
            node = node.next;
        }
        int i = 0;
        while(i < (stack.size()/2) ){
            if(stack.pop().val != queue.poll().val){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
//        System.out.println(isPalindrome(new ListNode(1,new ListNode(2))));
//        System.out.println(isPalindrome(new ListNode(1,new ListNode(2,new ListNode(1)))));
        System.out.println(isPalindrome(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1)))))));
        System.out.println(isPalindrome(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))));
    }
}
