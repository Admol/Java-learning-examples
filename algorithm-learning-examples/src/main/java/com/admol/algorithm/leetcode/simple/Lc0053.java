package com.admol.algorithm.leetcode.simple;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],  输出: 6  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author : jingling
 * @Date : 2020/6/11
 */
public class Lc0053{

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        // 累加的和
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                // 前面的累加和大于0, 继续累加起来
                sum += num;
            } else {
                // 和小于等于0,放弃前面的累加
                sum = num;
            }
            // 选择是否要更新成计算的最大的和
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(nums));
        nums = new int[]{-2,5,-3,-1};
        System.out.println(maxSubArray(nums));
    }
}
