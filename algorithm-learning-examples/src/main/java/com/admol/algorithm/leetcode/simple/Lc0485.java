package com.admol.algorithm.leetcode.simple;

/**
 * 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * @author : admol
 * @Date : 2020/7/13
 */
public class Lc0485{

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        int res = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                max++;
            }else{
                res = Math.max(res,max);
                max = 0;
            }
        }
        return Math.max(res,max);
    }

    public static void main(String[] args){
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
