package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0160{
    /**
     * 假设有两个链表:
     * A={1,3,5,7,9,11}
     * B={2,4,9,11}
     * 让它们向后逐结点遍历
     * B短, 当B到达链尾的时候,指向A的头结点,当A达到链尾的时候,指向B的头结点,
     * 可以看做为两个新的链表
     * A'={1,3,5,7,9,11,2,4,9,11}
     * B'={2,4,9,11,1,3,5,7,9,11}
     * 如果两个链表存在相交，它们末尾的结点必然相同
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode one = headA;
        ListNode two = headB;
        while(one != two){
            one = (one == null) ? headB : one.next;
            two = (two == null) ? headA : two.next;
        }
        return one;
    }
}
