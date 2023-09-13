package com.admol.algorithm.coursera;

/**
 * Quick Find 是一种用于解决并查集（Disjoint Set）问题的基本算法。
 * 并查集问题涉及维护一个集合的数据结构，通常用于管理一组不相交的元素，例如网络连接的连通性、社交网络中的好友关系等。
 * Quick Find 算法是其中一种简单的实现方式。
 */
public class QuickFind {
    // 用于存储元素的标识符
    private final int[] id;

    // 初始化并查集，每个元素初始时属于自己的集合
    public QuickFind(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    // 查找元素所属的集合标识符
    public int find(int p) {
        return id[p];
    }

    // 判断两个元素是否属于同一个集合
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 要合并两个集合，只需将其中一个集合的所有元素的标识符更改为另一个集合的标识符。
     * 这样，两个集合就会合并成一个。
     * @param p p
     * @param q q
     */
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        // 如果两个元素属于不同的集合，将它们合并成一个
        if (pId != qId) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 10;
        QuickFind uf = new QuickFind(size);

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(8, 9);

        System.out.println("Is 0 connected to 7? " + uf.isConnected(0, 7)); // false
        System.out.println("Is 1 connected to 9? " + uf.isConnected(1, 9)); // true

        uf.union(1, 7);
        uf.union(1, 9);

        System.out.println("Is 0 connected to 7? " + uf.isConnected(0, 7)); // true
        System.out.println("Is 1 connected to 9? " + uf.isConnected(1, 9)); // true
        System.out.println("Is 7 connected to 9? " + uf.isConnected(7, 9)); // true
    }
}
