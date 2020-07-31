package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;


/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * @author : admol
 * @Date : 2020/7/30
 */
public class Lc0543{
    int max = 1;

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        // 直径等效于求路径经过节点数的最大值减一
        return max-1;
    }


    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        // 1.遍历完该节点的左右节点后, 计算他们的直径是否为最大的
        max = Math.max(max,l+r+1);
        // 2.Math.max(l,r) 返回左右节点路径长的一边
        return Math.max(l,r)+1;
    }

    public static void main(String[] args){
        System.out.println(new Lc0543().
                diameterOfBinaryTree(
                        new TreeNode(1,
                        new TreeNode(2,new TreeNode(4,null,new TreeNode(6,new TreeNode(8),null)),new TreeNode(5,null,new TreeNode(7,null,new TreeNode(9)))),
                        new TreeNode(3))
                ));
        System.out.println(new Lc0543().
                diameterOfBinaryTree(new TreeNode(236,new TreeNode(104,null,new TreeNode(227)),new TreeNode(701,null,new TreeNode(911)))));
    }

}
