package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * @author : admol
 * @Date : 2020/7/29
 */
public class Lc0501{

    /** 上一个数 */
    static Integer preNum = 0;
    /** 上一个数出现的次数 */
    static int preNumCount = 0;
    /** 出现最多次数 */
    static int maxCount = 0;
    /** 有几个众数 */
    static int count = 1;
    /** 结果集 */
    static int[] ans;
    static int i = 0;

    /**
     * 二叉搜索树中序遍历的结果是一个递增序列, 此问题可以转换成求一个递增序列的众数
     * 思路: 两次中序遍历
     * 第一次中序遍历, 众数出现的次数是多少(maxCount), 统计出有几个众数(count)
     * 第二次中序遍历, 初始化结果数组, 找到出现最多次数的众数, 添加到结果集中
     * @param root
     * @return
     */
    public static int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        countMax(root,false);
        ans = new int[count];
        preNumCount = 0;
        countMax(root,true);
        return ans;
    }

    /**
     *
     * @param root
     * @param flag true:表示第二次中序遍历
     */
    private static void countMax(TreeNode root,boolean flag){
        if(root == null){
            return;
        }
        countMax(root.left,flag);
        // 中序代码
        if(preNum != null && preNum == root.val){
            // 数字是否重复出现, 重复计数+1
            preNumCount++;
        }else {
            // 出现了新的数字, 重置出现次数的计数
            preNum = root.val;
            preNumCount = 1;
        }
        if(flag){
            // 第二次遍历, 是否找到了众数
            if(preNumCount == maxCount){
                ans[i++] = root.val;
            }
        }else{
            // 第一次遍历, 统计每个数出现的次数
            if(maxCount == preNumCount){
                count++;
            }else if(preNumCount > maxCount){
                // 找到出现最多的次数
                count = 1;
                maxCount = preNumCount;
            }
        }
        countMax(root.right,flag);

    }


    public static void main(String[] args){
        System.out.println(findMode(new TreeNode(2147483647)));
//        System.out.println(findMode(new TreeNode(1,null,new TreeNode(2,new TreeNode(2),null))));
//        System.out.println(findMode(new TreeNode(0,new TreeNode(-3,new TreeNode(-10),new TreeNode(-3)),new TreeNode(9,new TreeNode(9),new TreeNode(9)))));
    }
}
