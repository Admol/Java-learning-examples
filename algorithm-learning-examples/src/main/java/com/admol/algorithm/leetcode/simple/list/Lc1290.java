package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

/**
 * 二进制链表转整数
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 *
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * @author : admol
 * @Date : 2020/7/28
 */
public class Lc1290{


    /**
     *
     * 二进制转10进制
     * 从高位往第位遍历
     * 每获取一位数值，将之前获取的数值左移一位（乘2）再加上新获取的一位即可
     * 比如: 1011
     * 2^3 + 2^1 + 2^0 = 11
     * 初始 ans: 0
     * 第一次: 0 == > 0*2 + 1 == > 1;
     * 第二次: 1 == > 1*2 + 0 == > 2;
     * 第三次: 2 == > 2*2 + 1 == > 5;
     * 第四次: 4 == > 5*2 + 1 == > 11;
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans <<= 1;
            ans += cur.val;
            cur = cur.next;
        }
        return ans;
    }


    /**
     * 遍历拼接字符串, 然后调用api
     * @param head
     * @return
     */
    public static int getDecimalValue1(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val);
            node = node.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }

    public static void main(String[] args){
        System.out.println(getDecimalValue(new ListNode(1,new ListNode(0,new ListNode(1)))));
    }
}
