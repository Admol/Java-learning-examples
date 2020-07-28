package com.admol.algorithm.leetcode.simple.list;

import com.admol.algorithm.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * @author : admol
 * @Date : 2020/7/28
 */
public class Interview0201{


    /**
     * 利用双重循环, 遍历节点, 每次把遍历的节点与后面的所有节点进行比较, 重复, 就删除后面的重复节点
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes1(ListNode head) {
        ListNode curr = head;
        while(curr != null){
                ListNode i = curr;
                while(i.next!= null){
                    if(curr.val == i.next.val){
                        // 删除i.next节点
                        i.next = i.next.next;
                    }else{
                        i = i.next;
                    }
                }
                curr = curr.next;
        }
        return head;
    }
    /**
     * Hash
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        ListNode pre = head;
        while(node != null){
            if(set.contains(node.val)){
                // 重复节点, 删除该节点
                pre.next = node.next;
                node = node.next;
            }else {
                set.add(node.val);
                pre = node;
                node = node.next;
            }

        }
        return head;
    }

    public static void main(String[] args){
        System.out.println(removeDuplicateNodes(new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(1,new ListNode(4,new ListNode(5))))))));
    }
}
