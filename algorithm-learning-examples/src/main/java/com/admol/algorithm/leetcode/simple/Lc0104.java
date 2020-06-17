package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * @author : admol
 * @Date : 2020/6/16
 */
public class Lc0104{

    /**
     * 递归
     * 时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)
     * 其中 N是结点的数量。
     * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度），
     * 因此保持调用栈的存储将是 O(N)O(N)。但在最好的情况下（树是完全平衡的），树的高度将是log(N)。
     * 因此，在这种情况下的空间复杂度将是 O(log(N))
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            // 如果没有任何的子节点
            return 0;
        } else {
            // 每个节点都可以拆分为,看它的左节点和右节点深度
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            // 1.初始化队列, 根节点所在深度为1
            stack.add(new Pair(root, 1));
        }

        // 记录整棵树的深度
        int depth = 0;
        while (!stack.isEmpty()) {
            // 从队列取出树节点
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            if (root != null) {
                // 当前树节点所在的深度
                int current_depth = current.getValue();
                depth = Math.max(depth, current_depth);
                // 将左右节点依次加入到队列
                if(root.left != null){
                    // 把左节点 以及左节点所在的深度加入到队列
                    stack.add(new Pair(root.left, current_depth + 1));
                }
                if(root.right != null){
                    // 把右节点 以及右节点所在的深度加入到队列
                    stack.add(new Pair(root.right, current_depth + 1));
                }
            }
        }
        return depth;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null)));
        System.out.println(maxDepth2(root));
    }

}
