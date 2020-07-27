package com.admol.algorithm.leetcode.simple.array;

import java.util.Arrays;

/**
 *
 * 查询后的偶数和
 *
 * 给出一个整数数组 A 和一个查询数组 queries。
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * @author : admol
 * @Date : 2020/7/27
 */
public class Lc0985{

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[A.length];
        // 原来A数组的偶数和
        int evenSum =0;
        //        int evenSum = Arrays.stream(A).filter(a->(a & 1) != 1).sum();
        for(int num : A){
            // 求之前数组A的偶数和
            if((num & 1) != 1){
                evenSum+=num;
            }
        }
        for(int i = 0; i < A.length; i++){
            int val = queries[i][0];
            int index = queries[i][1];
            // 当前A数组的数
            int curr = A[index];
            // 更新后的A数组
            A[index] += val;
            if((curr & 1 )!= 1 && (A[index] & 1 )!= 1){
                // 1.改变前后都是偶数, 只需要加上新增的部分val
                evenSum+=val;
            }else if((curr & 1 )!= 1){
                // 2.改变前是偶数, 改变后是奇数, 减去之前的偶数
                evenSum-=curr;
            }else if((A[index] & 1 )!= 1) {
                // 3.改变前是奇数, 改变后是偶数, 加上最新的数
                evenSum+=A[index];
            }
            // 根据索引赋值结果数组
            ans[i] = evenSum;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(sumEvenAfterQueries(new int[]{1,2,3,4},
                new int[][]{
                        {1,0},{-3,1},{-4,0},{2,3}
                }));
        System.out.println(sumEvenAfterQueries(new int[]{1},
                new int[][]{
                        {4,0}
                }));

    }
}
