package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 *
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 *
 * @author : admol
 * @Date : 2020/8/10
 */
public class Lc0993{
    /** 计算节点的深度 */
    HashMap<Integer, Integer> depth;
    /** 记录节点的父节点 */
    HashMap<Integer, TreeNode> parent;

    /**
     * DFS 深度优先
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x).equals(depth.get(y)) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    /**
     * 广度优先 bfs
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins1(TreeNode root,int x,int y) {
        if(root == null){
            return false;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            int[] cache = new int[101];
            for(int i = 0; i < size; i++){
                TreeNode node = list.pollFirst();
                // 判断是否为同一个父节点
                if(node.left != null && node.right != null){
                    if((node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y)){
                        return false;
                    }
                }
                cache[node.val] = 1;
                if(node.left != null){
                    list.addLast(node.left);
                }
                if(node.right != null){
                    list.addLast(node.right);
                }
            }
            if(cache[x] == 1 && cache[y] == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(6,new TreeNode(7),new TreeNode(8)));
        System.out.println(new Lc0993().isCousins(root,3,6));
        System.out.println(new Lc0993().isCousins(root,2,8));
    }
}
