package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;


/**
 * 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 提示：
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * @author : admol
 * @Date : 2020/7/29
 */
public class Lc0530{

    /** 上一个节点*/
    TreeNode preNode = null;
    /** 最小差值 */
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        getMinimumDifference(left);
        // 中序遍历代码逻辑begin //
        if(preNode != null){
            min = Math.min(min,root.val - preNode.val);
            if(min == 0){
                // 遇到最小的了直接退出
                return 0;
            }
        }
        preNode = root;
        TreeNode right = root.right;
        // 中序遍历代码逻辑end //
        getMinimumDifference(right);
        return min;
    }

    public static void main(String[] args){
        System.out.println(new Lc0530().getMinimumDifference(new TreeNode(1,null,new TreeNode(2,new TreeNode(2),null))));
        System.out.println(new Lc0530().getMinimumDifference(new TreeNode(1,null,new TreeNode(4,null,new TreeNode(9)))));
        System.out.println(new Lc0530().getMinimumDifference(new TreeNode(236,new TreeNode(104,null,new TreeNode(227)),new TreeNode(701,null,new TreeNode(911)))));
    }
}
