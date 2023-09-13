package com.admol.algorithm.coursera;

/**
 * 快速合并算法，通常指的是快速合并查找算法（Quick Union），
 * 是解决动态连通性问题的一种算法。这个问题通常涉及一组对象，
 * 每个对象都有一个标识符，我们需要确定两个对象是否相互连接，以及如何将它们连接起来。
 */
public class QuickUnion {
    private int[] id;

    // 构造函数，初始化对象的标识符数组
    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            // 每个对象的初始标识符是自己
            id[i] = i;
        }
    }

    // 找到对象所属组的根节点
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    // 检查两个对象是否相互连接
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // 合并两个对象所属的组
    public void union(int p, int q) {
        // 找到 p 所属组的根节点
        int i = root(p);
        // 找到 q 所属组的根节点
        int j = root(q);
        // 将 p 所属组的根节点指向 q 所属组的根节点，完成合并
        id[i] = j;
    }

    public static class QuickUnionTest {
        public static void main(String[] args) {
            int N = 10; // 创建一个包含10个对象的集合

            QuickUnion quickUnion = new QuickUnion(N);

            // 执行一系列的连接操作
            quickUnion.union(0, 1);
            quickUnion.union(2, 3);
            quickUnion.union(4, 5);
            quickUnion.union(6, 7);
            quickUnion.union(8, 9);

            // 检查连接
            System.out.println("Is 0 connected to 1? " + quickUnion.connected(0, 1)); // 应该为 true
            System.out.println("Is 2 connected to 3? " + quickUnion.connected(2, 3)); // 应该为 true
            System.out.println("Is 4 connected to 5? " + quickUnion.connected(4, 5)); // 应该为 true
            System.out.println("Is 6 connected to 7? " + quickUnion.connected(6, 7)); // 应该为 true
            System.out.println("Is 8 connected to 9? " + quickUnion.connected(8, 9)); // 应该为 true

            System.out.println("Is 0 connected to 3? " + quickUnion.connected(0, 3)); // 应该为 false
            System.out.println("Is 1 connected to 4? " + quickUnion.connected(1, 4)); // 应该为 false
        }
    }

}
