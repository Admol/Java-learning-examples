package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 链接：https://leetcode-cn.com/problems/path-sum
 * @author : admol
 * @Date : 2020/6/22
 */
public class Lc0112{

    /**
     * 递归类减计算
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root,int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            // 1.访问到了叶子节点, 判断值是否相等
            return sum == root.val;
        }
        // 2.递归判断左(右)节点, sum减去节点的val值
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val) ;
    }

    /**
     * 递归累加计算
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum1(TreeNode root,int sum) {
        if(root == null){
            return false;
        }
        return pathSum(root,0,sum);
    }

    /**
     * 访问到到叶子节点 , 加法计算到叶子节点的和是否等于目标值。
     * @param node
     * @param value 记录到叶子节点路径上各个节点的val总和
     * @param sum
     * @return
     */
    private static boolean pathSum(TreeNode node,int value,int sum){
        if(node == null){
            return false;
        }
        value += node.val;
        if(node.left == null && node.right == null){
            // 已经到了叶子节点
            return sum == value;
        }
        return pathSum(node.left,value,sum) || pathSum(node.right,value,sum);
    }

    public static void main(String[] args){
        //[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
        TreeNode root = new TreeNode(1,
                new TreeNode(2,new TreeNode(3,new TreeNode(4,new TreeNode(5),new TreeNode(5)),new TreeNode(4)),new TreeNode(3,new TreeNode(4),new TreeNode(4))),
                new TreeNode(2,new TreeNode(3,new TreeNode(4),new TreeNode(4)),new TreeNode(3)));

//        TreeNode root = new TreeNode(1,new TreeNode(2,null,null),null);
        System.out.println(hasPathSum(root,10));
    }

}
