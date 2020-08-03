package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0669{

    /**
     * 先序遍历修建
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root,int L,int R) {
        if(root == null){
            return null;
        }

        // 1.如果根节点太小, 根节点的左节点可以直接不要, 再次尝试去修剪根节点的右边节点
        if(root.val < L){
            return trimBST(root.right,L,R);
        }
        // 2.如果根节点太大, 根节点的右节点可以直接不要, 再次尝试去修剪根节点的左边节点
        if(root.val > R){
            return trimBST(root.left,L,R);
        }
        // 3.继续遍历
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1,new TreeNode(0),new TreeNode(2));
        System.out.println(new Lc0669().trimBST(root,1,2));
    }
}
