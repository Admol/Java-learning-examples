package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * @author : admol
 * @Date : 2020/6/22
 */
public class Lc111{

    /**
     * 递归,深度优先
     * 时间复杂度：我们访问每个节点一次，时间复杂度为 O(N) ，其中 NN 是节点个数。
     * 空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用 NN （树的高度）次，因此栈的空间开销是 O(N) 。
     * 但在最好情况下，树是完全平衡的，高度只有 log(N)，因此在这种情况下空间复杂度只有 O(log(N)) 。
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            // 1.如果节点的左右子节点都为空, 返回1
            return 1;
        }
        // 2. 说明至少有一个节点不为空
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 3.有一个节点不为空, 就取不为空的, 都不为空, 取最小的
        return (left ==0 || right ==0) ? left + right + 1 : Math.min(left,right) + 1;
    }

    /**
     * 广度优先, 遇到第一个叶子节点(没有子节点:左右子节点都为空),则退出,统计深度
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     * @param root
     * @return
     */
    public static int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while(!queue.isEmpty()){
            // 深度统计
            minDepth++;
            int size = queue.size();
            for(int i = 0; i <size ; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    // 遇到第一个左右都为空, 则退出统计
                    return minDepth;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return minDepth;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1,new TreeNode(2,null,null),null);
        System.out.println(minDepth(root));
    }

}
