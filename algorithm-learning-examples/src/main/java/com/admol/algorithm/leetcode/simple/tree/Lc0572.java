package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * @author : admol
 * @Date : 2020/7/31
 */
public class Lc0572{

    /**
     * 递归
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s,TreeNode t) {
        if(t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        // isSubtree 递归每个节点
        // isSame  已该节点为根节点, 逐一比较节点, 是否为同一个树
        return isSubtree(s.left,t) || isSubtree(s.right,t) || isSame(s,t);
    }

    /**
     * 判断一棵树是否一样
     * @param s
     * @param t
     * @return
     */
    private boolean isSame(TreeNode s,TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSame(s.left,t.left) && isSame(s.right,t.right);
    }

    public static void main(String[] args){
        TreeNode s = new TreeNode(3, new TreeNode(4,new TreeNode(1),new TreeNode(2)),new TreeNode(5));
        TreeNode t = new TreeNode(3, new TreeNode(4,new TreeNode(1),new TreeNode(2)),new TreeNode(5));
        System.out.println(new Lc0572().isSubtree(s,t));
        t = new TreeNode(4, new TreeNode(1),new TreeNode(2));
        System.out.println(new Lc0572().isSubtree(s,t));
        s = new TreeNode(3, new TreeNode(4,new TreeNode(1),new TreeNode(2,new TreeNode(0),null)),new TreeNode(5));
        System.out.println(new Lc0572().isSubtree(s,t));
    }
}
