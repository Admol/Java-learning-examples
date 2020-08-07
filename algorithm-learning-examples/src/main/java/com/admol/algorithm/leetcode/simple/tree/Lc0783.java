package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *  
 *
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * @author : admol
 * @Date : 2020/8/6
 */
public class Lc0783{

    /** 中序遍历 上一个节点 */
    TreeNode pre = null;
    /** 最小差值 */
    int min = 0;
    /**
     * 1.二叉搜索树, 所以中序遍历是有序的
     * 2.这里的求最小值, 都是任意两个节点大的减去小的, 如果可以是负数的话, 问题就成了求最小值和最大值的差了
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        minDiffInBST(root.left);
        if(pre!=null){
            min = Math.min(min,root.val - pre.val);
            // 因为题目给的是每个节点的值不重复, 所以最小差值肯定只能是1
            if(min == 1){
                return min;
            }
        }
        pre = root;
        minDiffInBST(root.right);
        return min;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1,new TreeNode(0),new TreeNode(2));
        System.out.println(new Lc0783().minDiffInBST(root));
    }

}
