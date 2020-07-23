package com.admol.algorithm.leetcode.medium;

/**
 * 标签:数组
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * @author : admol
 * @Date : 2020/7/23
 */
public class Lc0061{

    /**
     * 动态规划:
     * 思路:
     * 根据规则:每次只能向下或者向右移动一步,可以发现要达到右下角,必须要达到左边和上面一个,
     * 选择其中小的一个路径再加上右下角的路径,就是最终的结果了,
     * 用表达式表示就是: dp[i][j] = grid[i][j] + min(dp[i-1][j] ,dp[i][j-1] );
     * 但是第一行因为不可以从上面向下移动, 只能通过向右移动,  第一列左边没有路径不可以向右移动, 只能从上向下移动, 所以要单独处理
     * 只需要用一个二维数组dp[][], 每个点存储到达grid[][]上每个点的最小路径就行了
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        // 如果题目允许的话, 可以不需要dp, 直接在grid上面修改
        int[][] dp = new int[r][c];
        // 1.起点
        dp[0][0] = grid[0][0];
        // 2.计算最上面第一行, 到达每个点需要的最短路径, 且只能向右移动
        for(int i = 1; i < c; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        // 3.计算最左边第一列, 到达每个点需要的最短路径, 且只能向下移动
        for(int i = 1; i < r; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        // 4.填充剩下的
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j] ,dp[i][j-1] );
            }
        }
        // 5.返回到达右下角的最短路径
        return dp[r-1][c-1];
    }


    /**
     * 针对dp空间优化, 只存储上一行的最短路径
     * @param grid
     * @return
     */
    public static int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;

        int[] up = new int[c];
        // 行
        for(int i = 0; i < r; i++){
            // 列
            for(int j = 0; j < c; j++){
                if(i == 0 && j > 0){
                    // 第一行
                    up[j] = grid[0][j] + up[j-1];
                }else if(j == 0){
                    // 第一列
                    up[j] = grid[i][j] + up[j];
                }else {
                    // 其他的
                    // 公式: up[j] = Math.min(grid[i][j] + up[j] ,grid[i][j-1]+up[j-1] )
                    up[j] = Math.min(grid[i][j] + up[j] ,grid[i][j]+up[j-1]);
                }
            }
        }
        return up[c-1];
    }

    public static void main(String[] args){
        System.out.println(minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
        System.out.println(minPathSum1(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }


}
