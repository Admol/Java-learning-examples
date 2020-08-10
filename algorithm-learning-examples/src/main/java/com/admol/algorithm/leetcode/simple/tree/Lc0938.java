package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * @author : admol
 * @Date : 2020/8/10
 */
public class Lc0938{

    int ans = 0;
    public int rangeSumBST(TreeNode root,int L,int R) {
        if(root==null){
            return ans;
        }
        if(L <= root.val && root.val <= R){
            // 满足条件, 累加结果
            ans += root.val;
        }
        if(L < root.val){
            rangeSumBST(root.left,L,R);
        }
        if(R > root.val){
            rangeSumBST(root.right,L,R);
        }
        return ans;
    }

    int sum = 0;
    /**
     * 用全局变量sum 来存储计算结果
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST1(TreeNode root,int L,int R) {
        if(root==null){
            return 0;
        }
       rangeSumBST1(root.left,L,R);
        if(L <= root.val && root.val <= R){
            sum +=root.val;
        }
        if(root.val > R){
            return sum;
        }
        rangeSumBST1(root.right,L,R);
        return sum;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(6,new TreeNode(7),new TreeNode(8)));
        System.out.println(new Lc0938().rangeSumBST(root,5,8));
    }
}
