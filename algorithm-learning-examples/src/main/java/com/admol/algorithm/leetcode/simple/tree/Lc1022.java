package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *  
 *
 * 提示：
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * @author : admol
 * @Date : 2020/8/10
 */
public class Lc1022{

    /** 最终结果 */
    int ans = 0;

    /**
     * dfs 递归
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans % (1000000000+7);
    }

    /**
     * 从高位往低位遍历二进制的逻辑可以看 Lc1290
     * 每往低位遍历一位数值，将之前获取的计算数值左移一位（乘2）再加上新获取的一位即可
     * @param node
     * @param sum
     */
    private void dfs(TreeNode node,int sum){
        if(node != null){
            sum = (sum << 1) + node.val;
            if(node.left == null && node.right == null){
                ans  += sum;
            }else {
                dfs(node.left,sum);
                dfs(node.right,sum);
            }

        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1,new TreeNode(0,new TreeNode(0),new TreeNode(1)),new TreeNode(1,new TreeNode(0),new TreeNode(1)));
        System.out.println(new Lc1022().sumRootToLeaf(root));
    }
}
