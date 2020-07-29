package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * @author : admol
 * @Date : 2020/7/29
 */
public class Lc0404{


    public static int sumOfLeftLeaves(TreeNode root) {
        return sumLeftNull(root,0);
    }

    private static int sumLeftNull(TreeNode root,int sum){
        if(root == null){
            return sum;
        }
        TreeNode left = root.left;
        // 1.左节点不为空并且左节点是叶子节点
        if(left != null && left.left == null && left.right == null){
            sum += left.val;
        }
        // 2.继续寻找左边是否有满足条件的左叶子节点
        int sumLeft = sumLeftNull(left,sum);
        TreeNode right = root.right;
        // 3.继续寻找右边是否有满足条件的右叶子节点
        return sumLeftNull(right,sumLeft);
    }

    /**
     * 左叶子节点之和, 非左节点之和 !!!!!!!!!!!
     *
     * 这个方法求的是左节点之和
     * @param root
     * @return
     */
    public static int sumOfLeftLeavesXX(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumAllLeft(root,0);
    }
    public static int sumAllLeft(TreeNode node,Integer sum){
        if(node == null){
            return sum;
        }
        TreeNode left = node.left;
        if(left != null){
            sum+=left.val;
        }
        int sumLeft = sumAllLeft(left,sum);
        TreeNode right = node.right;
        return sumAllLeft(right,sumLeft);
    }

    public static void main(String[] args){
        System.out.println(sumOfLeftLeaves(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,new TreeNode(15),new TreeNode(7)))));
        System.out.println(sumOfLeftLeaves(new TreeNode(1,
                new TreeNode(2,new TreeNode(4),new TreeNode(5)),
                new TreeNode(3))));
    }
}
