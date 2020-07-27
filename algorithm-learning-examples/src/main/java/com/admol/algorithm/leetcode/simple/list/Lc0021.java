package com.admol.algorithm.leetcode.simple.list;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author : admol
 * @Date : 2020/6/9
 */
public class Lc0021{

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode();
        ListNode pre = result;
        while(true){
            if(l1 == null || l2 == null){
                // 有一个空的链表就退出
                break;
            }
            // 选值小的链表
            if(l1.val < l2.val){
                pre.next = l1;
                // L1节点被赋值成L1的next节点, 相当于去掉L1的头结点
                l1 = l1.next;
            }else{
                pre.next = l2;
                // L2节点被赋值成L2的next节点, 相当于去掉L2的头结点
                l2 = l2.next;
            }
            pre = pre.next;
        }
        //有一个还未被合并完
        pre.next = l1 == null ? l2 : l1;
        // 头节点没用到,返回值需要去掉
        return result.next;
    }

    /**
     * 递归的思想
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }

        @Override
        public String toString(){
            return val + "->" + next;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
//        ListNode node = mergeTwoLists(l1,l2);
//        System.out.println(node);

        System.out.println("递归:");
        l1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode node = mergeTwoLists2(l1,l2);
        System.out.println(node);

    }
}
