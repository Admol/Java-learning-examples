package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,11,12,15,7],
 *         3
 *     /       \
 *   9         20
 *  /  \      /  \
 * 11 13   15     7
 * 返回其自底向上的层次遍历为：
 * [
 *   [11,13,15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author : admol
 * @Date : 2020/6/17
 */
public class Lc0107{
    /**
     * 返回的结果要求是 自底向上, 从左至右
     * 但是我们遍历的时候只能从上至下来进行遍历
     * 所以我们可以根据栈的特性先进后出来进行遍历存储, 然后在顺序出栈, 就可以达到题目的目的了
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 1.添加根节点到队列
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每一层的数据
            List<Integer> floor = new ArrayList<>();
            // count 标识每层实际节点的数量, 根节点就是1
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                // 2.取出每层的节点
                TreeNode node = queue.poll();
                floor.add(node.val);
                // 3.将下一层节点加入到队列中, 队列的大小就是下一层的节点数
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            // 自底向上,每次都往队头塞
            result.addFirst(floor);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),new TreeNode(5,null,null)),new TreeNode(3,new TreeNode(6,null,null),new TreeNode(7,null,null)));
        List<List<Integer>>  result = levelOrderBottom(root);
        System.out.println(result);
    }
}
