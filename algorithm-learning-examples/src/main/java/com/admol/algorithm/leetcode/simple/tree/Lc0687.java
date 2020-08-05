package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 687. 最长同值路径
 *
 * 给定一个二叉树，
 * 找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 *
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * @author : admol
 * @Date : 2020/8/4
 */
public class Lc0687{

    /** 结果 */
    int ans = 0;

    /**
     * 递归, 求左右树的最长路径
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return ans;
        }
        pathLen(root);
        return ans;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    private int pathLen(TreeNode root){
        if(root==null){
            return 0;
        }
        int lenL = pathLen(root.left);
        int lenR = pathLen(root.right);
        // 后续遍历逻辑

        int pathLeft = 0;
        int pathRight = 0;
        // 1.如果左节点和根节点值相等, 则路径+1
        if(root.left != null && root.left.val == root.val){
            pathLeft = lenL + 1;
        }
        // 2.如果右节点和根节点值相等, 则路径+1
        if(root.right != null && root.right.val == root.val){
            pathRight = lenR + 1;
        }
        // 3.左右节点路径相加
        ans = Math.max(pathLeft+pathRight,ans);
        // 4.返回较长的一边路径
        return Math.max(pathLeft,pathRight);
    }
}
