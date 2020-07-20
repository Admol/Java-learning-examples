package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 图片平滑器
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 示例 1:
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 注意:
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 *
 * 链接：https://leetcode-cn.com/problems/image-smoother
 * @author : admol
 * @Date : 2020/7/20
 */
public class Lc0661{

    /**
     * imageSmoother1 写法简写
     * @param M
     * @return
     */
    public static int[][] imageSmoother(int[][] M) {
        int r = M.length,c = M[0].length;
        // 结果集
        int[][] res = new int[r][c];
        // 1.遍历矩阵
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int count = 0;
                int sum = 0;
                // 遍历M[i][j]元素的四周, 包括自己
                // 起点为r-1,表示当前行的上一行
                for(int ri = i-1; ri <= i+1; ri++){
                    // 起点j-1表示当前列的前一列
                    for(int cj = j-1; cj <= j+1 ; cj++){
                        // 确定范围, 不越界
                        if(ri >= 0 && ri < r && cj >= 0 && cj < c){
                            // 统计有效个数
                            count++;
                            sum += M[ri][cj];
                        }
                    }
                }
                // count至少会是1, 不会是0,因为当前节点也会统计
                res[i][j] = sum / count;
            }
        }
        return res;
    }
    /**
     * 遍历矩阵
     * @param M
     * @return
     */
    public static int[][] imageSmoother1(int[][] M) {
        // 结果集
        int[][] res = new int[M.length][M[0].length];
        // i:行
        for(int i = 0; i < M.length; i++){
            // j:列
            for(int j = 0; j < M[i].length; j++){
                // 统计当前数周边有效的数,包含自己
                int count = 1;
                // 当前索引值
                int curr = M[i][j];
                // 当前索引值周围的八个值的和
                int sum = curr;
                // 1.上一行(i-1),三个数
                if(i-1 >= 0){
                    if(j-1>=0){
                        sum += M[i-1][j-1];
                        count++;
                    }
                    sum += M[i-1][j];
                    count++;
                    if(j+1 < M[i].length){
                        sum += M[i-1][j+1];
                        count++;
                    }
                }
                // 2.当前行(i), 当前数的前后两个数之后
                if(0 < j){
                    sum += M[i][j-1];
                    count++;
                }
                if(j+1 < M[i].length){
                    sum += M[i][j+1];
                    count++;
                }
                // 3.下一行(i+1),计算三个数
                if(i+1<M.length){
                    if(j-1>=0){
                        sum += M[i+1][j-1];
                        count++;
                    }
                    sum += M[i+1][j];
                    count++;
                    if(j+1 < M[i].length){
                        sum += M[i+1][j+1];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(imageSmoother(new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        }));
    }
}
