package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0589{


    /**
     * 循环迭代
     * 利用栈的特性
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            if(node.children != null){
                for(int i = node.children.size() - 1; i >= 0; i--){
                    stack.add(node.children.get(i));
                }
            }
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        iter(res,root);
        return res;
    }

    private void iter(List<Integer> res,Node root){
        if(root == null){
            return;
        }
        res.add(root.val);
        if(root.children != null){
            for(Node child : root.children){
                iter(res,child);
            }
        }
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
        System.out.println(new Lc0589().preorder(root));
    }
}
