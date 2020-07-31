package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 例如，给定一个 3叉树 :
 * 我们应返回其最大深度，3。
 *
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * @author : admol
 * @Date : 2020/7/31
 */
public class Lc0559{

    /**
     * 深度优先 dfs
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        if(root.children != null){
            for(Node child : root.children){
                ans = Math.max(ans,maxDepth(child));
            }
        }
        return ans+1;
    }
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        LinkedList<Node> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(node != null && node.children != null){
                    queue.addAll(node.children);
                }
            }
            ans++;
        }
        return ans;

    }

    public static void main(String[] args){
        Node root = new Node(1);
        List<Node> rootChildren = new ArrayList<>();
        List<Node> children = new ArrayList<>();
        children.add(new Node(5));
        children.add(new Node(6));
        rootChildren.add(new Node(3,children));
        rootChildren.add(new Node(2));
        rootChildren.add(new Node(4));
        root.children = rootChildren;
        System.out.println(new Lc0559().maxDepth(root));
    }
}
