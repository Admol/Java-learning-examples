package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0226{

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // 1.取当前节点的左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2.交换左右子树, 即翻转
        TreeNode temp = left;
        left = right;
        right = temp;
        // 3.重新赋值当前节点的左右子树
        root.left = left;
        root.right = right;
        // 4.继续翻转下一节点
        invertTree(left);
        invertTree(right);
        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));
        System.out.println(invertTree(root));
    }
}
