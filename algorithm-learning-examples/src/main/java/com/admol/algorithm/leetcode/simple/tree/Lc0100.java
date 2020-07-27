package com.admol.algorithm.leetcode.simple.tree;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *         [1,2,3],   [1,2,3]
 * 输出: true
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *         [1,2],     [1,null,2]
 * 输出: false
 * 示例 3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *         [1,2,1],   [1,1,2]
 * 输出: false
 * @author : admol
 * @Date : 2020/6/16
 */
public class Lc0100{
    /**
     * 使用递归
     * 时间复杂度 : O(N)，其中 N 是树的结点数，因为每个结点都访问一次
     * 空间复杂度 : 最优情况（完全平衡二叉树）时为 O(log(N))，最坏情况下（完全不平衡二叉树）时为 O(N)，用于维护递归栈。
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 1.比较当前节点
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        // 2.继续递归比较左子树 和 右子树
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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

    public static void main(String[] args){
//        TreeNode p = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,null,null));
//        TreeNode q = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(4,null,null));
        TreeNode p = new TreeNode(1,new TreeNode(2,null,null),null);
        TreeNode q = new TreeNode(1,null,new TreeNode(2,null,null));
        System.out.println(isSameTree(p,q));
    }
}
