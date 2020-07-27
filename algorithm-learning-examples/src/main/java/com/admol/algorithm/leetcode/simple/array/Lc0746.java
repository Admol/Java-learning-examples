package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *
 * 示例 2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]
 *
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 *
 * 1.首先选择一个开始爬的楼梯: 0 or 1
 * 2.每次可以爬1步或2步
 * 3.每个阶梯需要的能量不一样, 求到达阶梯顶消耗的最小体力
 *
 * @author : admol
 * @Date : 2020/7/21
 */
public class Lc0746{

    /**
     * 动态规划:
     * 分析:
     * 每次爬一个阶梯或者爬两个阶梯,要达到楼层顶部,最后肯定会选择落在最后一个阶梯(n-1)上面或者倒数第二个阶梯(n-2)上面, 这个时候就可以直接跨多去了
     * 所以我们要从中间选择一个到达这两个楼梯层耗费体力最小的,
     * 如果用dp[i] 来表达踏上该阶梯需要耗费的体力,那么最终返回结果就应该是: min(dp[cost.length-1],dp[cost.length-2])
     * 那么踏上每一阶梯层耗费的体力怎么算呢? 要踏上该阶梯层肯定和踏上它前面两个阶梯层有关系, 而且要选择一个小的
     * 用关系表示就是:dp[i] = cost[i] + min(dp[i-1],dp[i-2]);
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        // 数组dp存储踏上阶梯需要耗费的最小体力
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    /**
     * 上面方法的数组, 最后其实很多没用到, 可以省略
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs1(int[] cost) {
        int one = cost[0];
        int two = cost[1];
        int curr = 0;
        for(int i = 2; i < cost.length; i++){
            curr = Math.min(one,two)+cost[i];
            one = two;
            two = curr;
        }
        return Math.min(one,two);
    }


    public static void main(String[] args){
        System.out.println(minCostClimbingStairs(new int[]{10,15,2}));
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{0,0,1,1}));
        System.out.println(minCostClimbingStairs(new int[]{0,0,0,1}));
        System.out.println(minCostClimbingStairs(new int[]{0,1,2,2}));
        System.out.println(minCostClimbingStairs(new int[]{1,2,2,0}));
        System.out.println(minCostClimbingStairs(new int[]{5, 10, 15, 5, 5, 10, 5, 5, 10, 5}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
