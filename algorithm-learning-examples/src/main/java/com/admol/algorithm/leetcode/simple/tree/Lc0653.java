package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.HashSet;

/**
 * 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0653{

    HashSet<Integer> set = new HashSet<>();

    /**
     *
     * @param root
     * @param k
     * @return
     */
    private boolean findTarget(TreeNode root,int k){
        if(root==null){
            return false;
        }
        if(set.contains(root.val)){
            return true;
        }
        set.add(k-root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }

    public static void main(String[] args){
        TreeNode t2 = new TreeNode(5,new TreeNode(3),new TreeNode(9,new TreeNode(8),new TreeNode(11)));
        System.out.println(new Lc0653().findTarget(t2,8));
        t2 = new TreeNode(2,new TreeNode(0,new TreeNode(-4),new TreeNode(1)),new TreeNode(3));
        System.out.println(new Lc0653().findTarget(t2,-1));
        t2 = new TreeNode(0,new TreeNode(-1,new TreeNode(-3),null),new TreeNode(2,null,new TreeNode(4)));
        System.out.println(new Lc0653().findTarget(t2,-4));
    }
}
