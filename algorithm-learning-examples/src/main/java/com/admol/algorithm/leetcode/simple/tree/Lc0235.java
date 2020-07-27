package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * @author : admol
 * @Date : 2020/7/3
 */
public class Lc0235{

    /**
     * 迭代
     * 时间复杂度：O(N) 在最坏的情况下我们可能需要遍历 BST 中所有的节点。
     * 空间复杂度：O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        TreeNode node = root;
        int v1 = p.val;
        int v2 = q.val;
        while(node != null){
            int v = node.val;
            // 1.两个节点都在根节点的左边
            if(v > v1 && v > v2){
                node = node.left;
                continue;
            }
            // 2.两个节点都在根节点的右边
            if(v < v1 && v < v2){
                node = node.right;
                continue;
            }
            return node;
        }
        return node;
    }
    /**
     * 递归
     * 二叉搜索树（BST）的性质：
     * 1.节点 N 左子树上的所有节点的值都小于等于节点 N的值
     * 2.节点 N 右子树上的所有节点的值都大于等于节点 N的值
     * 3.左子树和右子树也都是 BST
     * 时间复杂度：O(N) 在最坏的情况下我们可能需要访问 BST 中所有的节点。
     * 空间复杂度：O(N) 所需开辟的额外空间主要是递归栈产生的，之所以是 N 是因为 BST 的高度为 N。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q) {
        int v = root.val;
        int v1 = p.val;
        int v2 = q.val;

        // 1.两个节点都在根节点的左边
        if(v > v1 && v > v2){
            // 继续已左节点为根节点进行递归查找
            return lowestCommonAncestor(root.left,p,q);
        }
        // 2.两个节点都在根节点的右边
        if(v < v1 && v < v2){
            // 继续已右节点为根节点进行递归查找
            return lowestCommonAncestor(root.right,p,q);
        }
        // 3. 剩下的是一个在左边 一个在右边, 所以该节点肯定为公共祖先了
        return root;
    }

    public static void main(String[] args){
        TreeNode left = new TreeNode(2,new TreeNode(0),new TreeNode(4));
        TreeNode right = new TreeNode(8,new TreeNode(7),new TreeNode(9));
        System.out.println(lowestCommonAncestor(new TreeNode(6,left,right),new TreeNode(2),new TreeNode(8)).val);
        System.out.println(lowestCommonAncestor(new TreeNode(6,left,right),new TreeNode(2),new TreeNode(5)).val);
        System.out.println(lowestCommonAncestor(new TreeNode(6,left,right),new TreeNode(8),new TreeNode(5)).val);
        System.out.println(lowestCommonAncestor(new TreeNode(6,left,right),new TreeNode(3),new TreeNode(5)).val);
    }

}
