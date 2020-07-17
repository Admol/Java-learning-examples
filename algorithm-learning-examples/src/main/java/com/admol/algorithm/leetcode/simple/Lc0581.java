package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;

/**
 * 标签:数组
 * 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * @author : admol
 * @Date : 2020/7/16
 */
public class Lc0581{
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return 0;
        }
        int high = 0, low = len-1, max = nums[0], min = nums[len-1];
        for(int i = 1; i < len; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-1-i]);
            if(nums[i] < max){
                high = i;
            }
            if(nums[len-1-i] > min){
                low = len-1-i;
            }
        }
        return high > low ? high - low + 1 : 0;
    }

    /**
     * 思路:排序后比较
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray1(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int len = temp.length;
        int start = len;
        int end = 0;
        for(int i = 0; i < len/2+1; i++){
            if (temp[i] != nums[i]) {
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
            int last = len-1-i;
            if (temp[last] != nums[last]) {
                start = Math.min(start,last);
                end = Math.max(end,last);
            }

        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    public static void main(String[] args){
//        System.out.println(findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,5,4}));
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
