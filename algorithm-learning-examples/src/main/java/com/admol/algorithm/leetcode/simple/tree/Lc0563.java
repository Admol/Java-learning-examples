package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例：
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *  
 * 提示：
 * 任何子树的结点的和不会超过 32 位整数的范围。
 * 坡度的值不会超过 32 位整数的范围。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * @author : admol
 * @Date : 2020/7/31
 */
public class Lc0563{

    /** 整个树的坡度 */
    int slope = 0;

    /**
     * 整个树的坡度就是其所有节点的坡度之和。
     * 后续遍历
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        everyOne(root);
        return slope;
    }

    /**
     * 递归求每个节点的坡度, 并累加起来
     * @param root
     * @return
     */
    private int everyOne(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = everyOne(root.left);
        int right = everyOne(root.right);
        // 后续遍历逻辑
        // 1.总的坡度
        slope += Math.abs(left-right);
        // 2.返回当前节点的所有和
        return left+right+root.val;
    }


    public static void main(String[] args){
        System.out.println(new Lc0563().findTilt(new TreeNode(1,new TreeNode(2),new TreeNode(3))));
        System.out.println(new Lc0563().findTilt(new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4,new TreeNode(5),null),null),null),null)));
        System.out.println(new Lc0563().findTilt(new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,new TreeNode(5),null))));
    }
}
