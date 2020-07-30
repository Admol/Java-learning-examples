package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * @author : admol
 * @Date : 2020/7/30
 */
public class Lc0538{

    int backSum = 0;
    /***
     * 中序遍历, 右节点-->根节点-->左节点
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        convertBST(root.right);
        backSum += root.val;
        root.val = backSum;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args){
        System.out.println(new Lc0538().convertBST(new TreeNode(1,null,new TreeNode(2,new TreeNode(2),null))));
        System.out.println(new Lc0538().convertBST(new TreeNode(236,new TreeNode(104,null,new TreeNode(227)),new TreeNode(701,null,new TreeNode(911)))));

    }
}
