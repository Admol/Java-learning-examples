package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 897. 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * @author : admol
 * @Date : 2020/8/7
 */
public class Lc0897{
    /** 中序遍历时, 记录上一个节点 */
    TreeNode pre = null;
    /** 结果树 */
    TreeNode ans = new TreeNode(0);

    TreeNode cur;

    /**
     * 递归  改变节点的指向
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }
    public void inorder(TreeNode node) {
        if (node == null){
            return;
        }
        inorder(node.left);
        // 中序遍历
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    /**
     * 递归, 重新 new 一个节点
     * @param root
     * @return
     */
    public TreeNode increasingBST1(TreeNode root) {
        if(root == null){
            return null;
        }
        increasingBST(root.left);
        if(pre == null){
            pre = new TreeNode(root.val);
            ans.right = pre;
        }else {
            pre.right = new TreeNode(root.val);
            pre = pre.right;
        }
        increasingBST(root.right);

        return ans.right;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(6,null,new TreeNode(8)));
        System.out.println(new Lc0897().increasingBST(root));
    }
}
