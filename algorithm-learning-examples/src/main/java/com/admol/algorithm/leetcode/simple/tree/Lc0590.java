package com.admol.algorithm.leetcode.simple.tree;

import com.admol.algorithm.leetcode.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * @author : admol
 * @Date : 2020/8/3
 */
public class Lc0590{
    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.removeLast();
            res.addFirst(node.val);
            if(node.children != null){
                for(Node child : node.children){
                    stack.add(child);
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
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        iter(res,root);
        return res;
    }

    private void iter(List<Integer> res,Node root){
        if(root == null){
            return;
        }
        if(root.children != null){
            for(Node child : root.children){
                iter(res,child);
            }
        }
        res.add(root.val);
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
        System.out.println(new Lc0590().postorder(root));
    }
}
