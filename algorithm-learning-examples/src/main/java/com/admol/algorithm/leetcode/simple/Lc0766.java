package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 托普利茨矩阵
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 * 说明:
 *
 *  matrix 是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 * 进阶:
 *
 * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 *
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * @author : admol
 * @Date : 2020/7/23
 */
public class Lc0766{


    /**
     * 观察:
     * 每一行的内容除去最后一个后, 都出现在下一行的除首个元素
     * @param matrix
     * @return
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        // i = 1 , 第一行不用判断
        for(int i = 1; i < r; i++){
            for(int j = 0; j < c; j++){
                // 每列的第一个元素不需要判断
                if(j>0 && matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2},
                {2,2},
        }));
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2},
                {5,1},
        }));
    }
}
