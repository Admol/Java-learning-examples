package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 注意:
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * @author : admol
 * @Date : 2020/7/20
 */
public class Lc0643{

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i < k; i++){
            // 1.第一次先计算出k个数的和作为max
            max += nums[i];
        }
        // 2.滑动窗口时, 记录上一次窗口的值
        int pre = max;
        for(int i = 1; i < nums.length-k+1; i++){
            // 3.计算当前窗口的值等于上一次窗口的值减去当前位置前一个值(i-1)再加上当前窗口段最后一个值(i+k-1)
            pre = pre - nums[i-1]+nums[i+k-1];
            // 4.计算最大值
            max = Math.max(max,pre);
        }
        // 5.计算平均值
        return max/(k*1.0);
    }
    /**
     * 暴力干
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage1(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= nums.length-k; i++){
            int sum = 0;
            for(int j = i; j < i+k; j++){
                sum+=nums[j];
            }
            res[i] = sum;
        }
        for(int i = 0; i < res.length; i++){
            max = Math.max(max,res[i]);
        }
        return max/(k*1.0);
    }

    public static void main(String[] args){
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
