package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0141{
    /**
     * 双指针, 类似两个速度不一样的人在环形操场上跑步一样, 速度不一样, 最后两个人肯定会相遇
     * 如果不是在环形操场上跑步, 而是在直跑道上面的话肯定不会相遇, 而是跑得快的人肯定会想到终点
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 跑得慢的人
        ListNode slow = head;
        // 跑得快的人
        ListNode fast = head.next;
        // 如果是环, 速度不一样的两个人肯定会相遇
        while(slow != fast){
            // 没相遇, 继续跑,检测是否会相遇
            if(fast == null || fast.next == null){
                // 有人跑到了终点, 没有环
                return false;
            }
            // 慢的人跑一步
            slow = slow.next;
            // 快的人跑两步
            fast = fast.next.next;
        }
        // 相遇了, 说明有环
        return true;
    }
    /**
     * 利用Hash表来存储每个链表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        int pos = 0;
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }
            pos++;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
