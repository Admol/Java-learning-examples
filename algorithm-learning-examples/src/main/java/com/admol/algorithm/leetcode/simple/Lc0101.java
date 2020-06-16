package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *          1
 *       /     \
 *      2       2
 *    /  \     /  \
 *   3   4    4   3
 *  / \ / \  / \  / \
 * 5  6 7 8 8  7 6  5
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author : admol
 * @Date : 2020/6/16
 */
public class Lc0101{


    /**
     * 递归的方式, 每次比较两个小的树, 是否对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        // 根节点的左树和右树
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 比较它们的左右子树
        return compare(left,right);
    }

    /**
     * 比较两颗小树是否对称
     * 左树的左节点和右树的右节点比较
     * 左树的右节点和右树的左节点比较
     * @param left
     * @param right
     * @return
     */
    public boolean compare(TreeNode left,TreeNode right){
        // 1.比较的两棵树都为空, 说明是对称的
        if(left  == null && right == null){
            return true;
        }
        // 2.两棵树有一颗不为空, 说明不对称
        if(left  == null || right == null){
            return false;
        }
        // 3.比较两棵树的值, 不相等说明不为空
        if(left.val != right.val){
            return false;
        }
        // 继续拿左树的左与右树的右进行比较 && 左树的右和右树的左进行比较
        return compare(left.left,right.right) && compare(left.right,right.left);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x,TreeNode l,TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }
}
