package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * @author : admol
 * @Date : 2020/7/28
 */
public class Offer06{


    public static int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }
        int[] ans = new int[count];
        if(count<1){
            return ans;
        }
        node = head;
        for(int i = count-1; i >= 0; i--){
            ans[i] = node.val;
            node = node.next;
        }
        return ans;
    }


    /**
     * 递归
     * @param head
     * @return
     */
    public static int[] reversePrint1(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        find(node,list);
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    private static ListNode find(ListNode cur,List<Integer> list){
        if(cur == null || cur.next == null){
            list.add(cur.val);
            return cur;
        }
        ListNode node = find(cur.next,list);
        list.add(cur.val);
        return node;
    }

    public static void main(String[] args){
        System.out.println(reversePrint(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))))));
    }
}
