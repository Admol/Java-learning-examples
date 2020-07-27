package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * @author : admol
 * @Date : 2020/6/17
 */
public class Lc0108{

    /**
     * 结果不唯一
     * 二叉搜索树的中序遍历是一个升序序列
     * 时间复杂度：O(N)，每个元素只访问一次。
     * 空间复杂度：O(N)，二叉搜索树空间 O(N)，递归栈深度 O(logN)。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if(length < 1){
            return null;
        }
        TreeNode tree = buildTree(nums,0,length-1);
        return tree;
    }

    private TreeNode buildTree(int[] nums,int l,int r){
        if(l>r){
            // 子树中不存在元素，返回空
            return null;
        }
        // 确定中间位置, 中间位置的不同,结果也可能不同
        int mid = (r-l) / 2 + l;
        // 根据中间位置创建根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 递归创建左右子节点
        root.left = buildTree(nums,l,mid-1);
        root.right = buildTree(nums,mid+1,r);
        return root;
    }
}
