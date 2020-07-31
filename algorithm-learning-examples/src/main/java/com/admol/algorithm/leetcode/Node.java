package com.admol.algorithm.leetcode;

import java.util.List;

/**
 * @author : admol
 * @Date : 2020/7/31
 */
public class Node{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
