package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0637{

    /***
     * 层级遍历
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            // 注意sum累加之后操作int范围, 所以用long 或者double
            long sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = list.pollFirst();
                if(curr.left != null){
                    list.add(curr.left);
                }
                if(curr.right != null){
                    list.add(curr.right);
                }
                sum += curr.val;
            }
            ans.add((sum*1.0)/size);
        }
        return ans;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4,new TreeNode(5),null),null),null),null);
//        System.out.println(new Lc0637().averageOfLevels(t1));
        TreeNode t2 = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(new Lc0637().averageOfLevels(t2));
    }
}
