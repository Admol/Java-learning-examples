package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 提示：
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 *
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * @author : admol
 * @Date : 2020/8/7
 */
public class Lc0872{
    /**
     * 因为两颗树的形状可能不一样,但是叶子节点的值是可能一样的, 所以不能同时遍历
     * 只能分别求出每个树的叶子节点, 然后进行比较
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1,TreeNode root2) {
        List<Integer> list1 = new ArrayList<>() ;
        // 1.找出第一棵树的所有叶子节点
        findLeafNode(root1,list1);
        List<Integer> list2 = new ArrayList<>() ;
        // 2.找出第二棵树的所有叶子节点
        findLeafNode(root2,list2);

        // 3.比较两棵树所有的叶子节点
        if(list1.size() != list2.size()){
            return false;
        }
        for(int i = 0; i < list1.size(); i++){
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 找出一棵树的叶子节点
     * @param root
     * @param list
     */
    private void findLeafNode(TreeNode root,List<Integer> list){
        if(root == null){
            return ;
        }
        findLeafNode(root.left,list);
        findLeafNode(root.right,list);
        if(root.left == null && root.right == null){
            // 当前root节点为root节点
            list.add(root.val);
        }
    }

    public static void main(String[] args){

        TreeNode root1 = new TreeNode(1,new TreeNode(0),new TreeNode(2));
        TreeNode root2 = new TreeNode(1,new TreeNode(-1),new TreeNode(2));
        System.out.println(new Lc0872().leafSimilar(root1,root2));
    }
}
