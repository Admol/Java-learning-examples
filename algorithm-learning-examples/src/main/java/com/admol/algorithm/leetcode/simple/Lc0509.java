package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 提示：
 * 0 ≤ N ≤ 30
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * @author : jingling
 * @Date : 2020/7/13
 */
public class Lc0509{

    /**
     * 借用数组
     * 其实可以不需要那么N+1长度的DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。
     * 所以，可以进一步优化，把空间复杂度降为 O(1), 就是循环: fib2
     * @param N
     * @return
     */
    public static int fib(int N) {
        if(N < 2){
            return N;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
    /**
     * 循环
     * @param N
     * @return
     */
    public static int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    /**
     * 递归
     * @param N
     * @return
     */
    public static int fib1(int N) {
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        return fib1(N-1) + fib1(N-2);
    }

    public static void main(String[] args){
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }
}
