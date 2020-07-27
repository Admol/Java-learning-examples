package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * @author : admol
 * @Date : 2020/7/21
 */
public class Lc0674{

    public static int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]){
                anchor = i;
            }
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS1(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int max = 1;
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                len++;
            }else {
                max = Math.max(len,max);
                len = 1;
            }
        }
        return Math.max(len,max);
    }

    public static void main(String[] args){
//        System.out.println(findLengthOfLCIS(new int[]{}));
//        System.out.println(findLengthOfLCIS(new int[]{1}));
//        System.out.println(findLengthOfLCIS(new int[]{1,2}));
//        System.out.println(findLengthOfLCIS(new int[]{3,2,1}));
        System.out.println(findLengthOfLCIS(new int[]{1,2,5,4,6}));
        System.out.println(findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }
}
