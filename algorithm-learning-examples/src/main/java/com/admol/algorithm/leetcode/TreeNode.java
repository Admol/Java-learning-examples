package com.admol.algorithm.leetcode;


/**
 * 二叉树
 * @author : admol
 * @Date : 2020/6/16
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x,TreeNode l,TreeNode r) {
        val = x;
        left = l;
        right = r;
    }

    public TreeNode(int x){
        val = x;
    }

    @Override
    public String toString(){
        return "TreeNode=" + val + ", left=" + left + ", right=" + right ;
    }
}
