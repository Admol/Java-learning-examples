package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

/**
 * 根据二叉树创建字符串
 *
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0606{

    /**
     * 递归
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    private void helper(TreeNode root,StringBuilder sb){
        if(root != null){
            sb.append(root.val);
            if(root.left != null || root.right != null){
                sb.append('(');
                //空节点用一对空括号表示
                //只允许左子树为空时用空括号替代节点，如果右子树为空或者左右子树都为空就无视
                helper(root.left, sb);
                sb.append(')');
                if(root.right != null){
                    sb.append('(');
                    helper(root.right, sb);
                    sb.append(')');
                }
            }
        }

    }
    /**
     * 递归
     * @param t
     * @return
     */
    public String tree2str1(TreeNode t) {
        if(t==null){
            return "";
        }
        if(t.left == null && t.right == null){
            return t.val+"";
        }
        if(t.right == null){
            return t.val+"("+tree2str(t.left)+")";
        }
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }
}
