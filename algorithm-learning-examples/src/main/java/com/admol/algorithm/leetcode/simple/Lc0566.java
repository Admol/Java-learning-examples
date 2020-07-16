package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 重塑矩阵
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *
 * 示例 2:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 注意：
 *
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 *
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * @author : admol
 * @Date : 2020/7/14
 */
public class Lc0566{

    /**
     * 遍历, 直接计算原来元素到新矩阵的索引
     * 还可以用队列, 但是会用到多余的存储空间
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length < 1 || nums.length * nums[0].length != r*c){
            return nums;
        }
        int[][] res = new int[r][c];
        // index标识遍历的计数
        int index = 0;
        // 遍历原二维数组
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                // index / c 计算新的行
                // index % c 计算新的列
                res[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return res;
    }

    /**
     * 根据index指定位置,将num放入到res数组中, 比如一个10*10的二维数组res, num:5, index:10 ,最后应该放入到res[1][0] = 5
     * @param num  5
     * @param index  6
     * @param res
     */
    private static void putInNewArray(int num,int index,int[][] res){
        // 列
        int lenlen = res[0].length;
        int i = index / lenlen;
        int j = index % lenlen;
        res[i][j] = num;
    }

    public static void main(String[] args){
        System.out.println(matrixReshape(new int[][]{{1,2,3},{4,5,6}},3,2));
    }
}
