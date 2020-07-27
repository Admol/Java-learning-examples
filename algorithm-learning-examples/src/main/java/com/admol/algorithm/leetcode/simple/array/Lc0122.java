package com.admol.algorithm.leetcode.simple.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * @author : admol
 * @Date : 2020/6/23
 */
public class Lc0122{

    /**
     * 官方的答案是写的真的简单(干得漂亮 = = )
     * [7,1,5,7,3,6,4]
     * 时间复杂度：O(n)，遍历一次。
     * 空间复杂度：O(1)，需要常量的空间。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * 和上一题的差异在可以多次交易,所以交易一次后, 相当于我们从0开始再次执行上一题一样的逻辑,
     * 简单一句话就是多次执行121题的逻辑
     * 时间复杂度：O(n)，遍历一次。
     * 空间复杂度：O(1)，需要常量的空间。
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int sum = 0;
        int profit = 0;
        if(prices.length <= 1){
            // 卖不了
            return profit;
        }
        // 可以买入的最小值
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                // 1.股票在涨, 计算波段收益
                profit = Math.max(profit,prices[i] - min);
            }else if(prices[i] < prices[i-1]){
                // 2.股票开始下跌, 卖出之前的股票, 累加收益
                sum += profit;
                // 重置收益, 开始进行下一波段的买卖
                profit = 0;
                // 重置最低价的股票
                min = prices[i];
            }
        }
        sum += profit;
        return sum;
    }

    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{7,1,5,7,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2,1,2,0,1}));
        System.out.println(maxProfit(new int[]{0,1,2,3,4}));
        System.out.println(maxProfit(new int[]{0,1}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[]{}));
    }
}
