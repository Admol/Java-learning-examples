package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 * @author : admol
 * @Date : 2020/8/5
 */
public class Lc0700{

    /**
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root,int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode ans = null;
        if(root.val > val){
            // 搜索左子树
            ans = searchBST(root.left,val);
        }
        if(root.val < val){
            // 搜索右子树
            ans =searchBST(root.right,val);
        }
        return ans;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));
        System.out.println(new Lc0700().searchBST(root,4));
    }
}
