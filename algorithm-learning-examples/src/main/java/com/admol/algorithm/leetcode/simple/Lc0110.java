package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * @author : admol
 * @Date : 2020/6/17
 */
public class Lc0110{

    /**
     *
     * @param root
     * @return
     */

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return think(root) != -1;
    }

    /**
     * 至底向上遍历
     * 计算一颗树左右子树中最大高度加 1 , 如果树是不平衡的则返回-1
     * 时间复杂度 O(N)： N 为树的节点数；最差情况下，需要递归遍历树的所有节点。
     * 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间。
     * @param node
     * @return
     */
    private static int think(TreeNode node){
        if (node == null){
            return 0;
        }
        // 1.递归找到最深的左子树节点
        int left = think(node.left);
        if(left == -1){
            return -1;
        }
        int right = think(node.right);
        if(right == -1){
            return -1;
        }
        //如果只是计算最大高度, 不判断平衡, 以后有关树高度的都可以在这里判断
        //return Math.max(left, right) + 1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 最开始理解错了题目给的平衡二叉树定义: 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 我理解成了整棵树的高度差
     * 像题目给的 [1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5] 就应该是一个平衡二叉树, 如果按照整棵树的高度差来看就不算是
     * @param root
     * @return
     */
    public static boolean isBalanced2(TreeNode root) {
        if(root == null){
            return true;
        }
        // 第一个节点没有叶子节点所在的层
        boolean flag = true;
        int full = 0;
        // 树的深度
        int depth =0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            depth++;
            if(depth >= full + 2){
                return false;
            }
            if(flag){
                full++;
            }
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left == null || right == null){
                    flag = false;
                }
                if(left != null){
                    queue.add(left);
                }
                if(right != null){
                    queue.add(right);
                }
            }
            System.out.println();
        }
        return true;
    }

    public static void main(String[] args){
//        TreeNode root = new TreeNode(1,null,new TreeNode(2,null,new TreeNode(3)));
//        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        //[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
        TreeNode root = new TreeNode(1,
                new TreeNode(2,new TreeNode(3,new TreeNode(4,new TreeNode(5),new TreeNode(5)),new TreeNode(4)),new TreeNode(3,new TreeNode(4),new TreeNode(4))),
                new TreeNode(2,new TreeNode(3,new TreeNode(4),new TreeNode(4)),new TreeNode(3)));
        //[1,2,2,3,3,null,null,4,4]
//        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),new TreeNode(4)),new TreeNode(3)),new TreeNode(2,null,null));

        boolean result = isBalanced(root);
        System.out.println(result);
    }
}
