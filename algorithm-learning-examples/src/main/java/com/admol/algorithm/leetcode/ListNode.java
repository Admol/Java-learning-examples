package com.admol.algorithm.leetcode;

/**
 * @author : admol
 * @Date : 2020/6/24
 */
public class ListNode{
    public ListNode next;
    public int val;
    public ListNode(int x) {
      val = x;
      next = null;
    }
    public ListNode(int x,ListNode next) {
      val = x;
      this.next = next;
    }

    @Override
    public String toString(){
        return "listNode:" + val + " ==> " + next;
    }
}
