package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 *
 * 提示：
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * @author : admol
 * @Date : 2020/8/10
 */
public class Lc0965{

    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        // 判断根节点和左右节点值是否一致
        boolean l = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
        boolean r = root.right == null || (root.val == root.right.val && isUnivalTree(root.right));
        return  l && r;
    }


    /** 记录上一个节点的值 */
    int pre = -1;
    public boolean isUnivalTree1(TreeNode root) {
        if(root==null){
            return true;
        }
        if(pre != -1 && root.val != pre){
            return false;
        }
        pre = root.val;
        return  isUnivalTree1(root.left) && isUnivalTree1(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1,new TreeNode(1,new TreeNode(1),new TreeNode(1)),new TreeNode(1,new TreeNode(1),new TreeNode(1)));
        System.out.println(new Lc0965().isUnivalTree(root));
    }
}
