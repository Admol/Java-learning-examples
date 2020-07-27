package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *  
 *
 * 示例：
 *
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid
 * @author : admol
 * @Date : 2020/7/23
 */
public class Lc0840{

    /**
     * 网格的总和是 45，因为网格必须是 1 到 9 不同的数字。
     * 每一列和行加起来必须是 15，乘以 3 则是网格的总和,中心必须是5
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        for (int r = 0; r < R-2; ++r){
            for (int c = 0; c < C-2; ++c) {
                // 中心必须是5
                if (grid[r+1][c+1] != 5){
                    continue;
                }
                if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                        grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                        grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2])){
                    ans++;
                }
            }
        }

        return ans;
    }
    public boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v: vals){
            count[v]++;
        }
        for (int v = 1; v <= 9; ++v){
            if (count[v] != 1){
                return false;
            }
        }

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}
