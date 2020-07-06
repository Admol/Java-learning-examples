package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0257{

    /***
     * 递归
     * 时间复杂度：O(N)，其中 N 表示节点数目。
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        buildPath("",root,res);
        return res;

    }

    private static void buildPath(String start,TreeNode node,LinkedList<String> res){
        if(node == null){
            return ;
        }
        start += Integer.valueOf(node.val);
        if(node.left == null && node.right == null){
            // 找到了叶子节点, 将路径加入到结果集中
            res.add(start);
            return;
        }
        // 继续递归
        start += "->";
        buildPath(start,node.left,res);
        buildPath(start,node.right,res);
    }

    public static void main(String[] args){
        binaryTreePaths(new TreeNode(1,new TreeNode(2,null,new TreeNode(5)),new TreeNode(3)))
                .stream().forEach(System.out::println);
        System.out.println("=============");
        binaryTreePaths(new TreeNode(1))
                .stream().forEach(System.out::println);
    }

}
