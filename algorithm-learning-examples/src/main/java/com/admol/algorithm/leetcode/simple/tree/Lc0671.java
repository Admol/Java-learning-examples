package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0671{


    /**
     * 暴力遍历, set
     * @param root
     * @return
     */
    public int findSecondMinimumValue1(TreeNode root) {
        if(root==null){
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        HashSet<Integer> set = new HashSet<>();
        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = stack.pop();
                set.add(curr.val);
                if(curr.left != null){
                    stack.add(curr.left);
                }
                if(curr.right != null){
                    stack.add(curr.right);
                }
            }
        }
        Integer[] a = new Integer[set.size()];
        set.toArray(a);
        Arrays.sort(a);
        for(Integer num : a){
            if(num>root.val){
                return num;
            }
        }
        return -1;
    }

    /**
     * 递归
     * 因为题目给的root节点值应该是最小的
     * 所以只需要从左右子树中分别找到第一个大于root节点的值(也就是除了root节点, 左右子树分别的最小值)
     * 然后都大于root.val, 则取他们中较小的, 其他情况, 选择较大的一个
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        return findMin(root, root.val);
    }

    /**
     *
     * @param node
     * @param val
     * @return
     */
    private int findMin(TreeNode node,int val){
        if (node == null) {
            return -1;
        }
        // 3.找到大于root节点的值, 则退出
        if (node.val > val) {
            return node.val;
        }
        // 1.找左子树第一个大于root.val的值
        int l = findMin(node.left, val);
        // 2.找右子树第一个大于root.val的值
        int r = findMin(node.right, val);
        // 4.比较
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(2));
        System.out.println(new Lc0671().findSecondMinimumValue(root));
        root = new TreeNode(2,new TreeNode(2),new TreeNode(2));
        System.out.println(new Lc0671().findSecondMinimumValue(root));
    }
}
