package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : jingling
 * @Date : 2020/7/24
 */
public class Lc0867{

    /**
     * 1 2 3        1 4 7
     * 4 5 6   == > 2 5 8
     * 7 8 9        3 6 9
     *
     * 1 2 3        1 4
     * 4 5 6  ==>   2 5
     *              3 6
     * 观察:
     * 之前的列是之后的行
     * 之前的行是之前的列
     * 所以我们只需要按照一列一列的遍历原二维数组就可以了
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] ans = new int[c][r];
        // i:原来的列
        for(int i = 0; i < c; i++){
            //j:原来的行
            for(int j = 0; j < r; j++){
                // 原来的列是之后的行,原来的行是之后的列
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }

    public static void main(String[] args){
        transpose(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        });
        transpose(new int[][]{
                {1,2,3},{4,5,6}
        });
    }
}
