package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;

/**
 * 标签:数组
 * 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * 通过次数22,129提交次数44,034
 *
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * @author : admol
 * @Date : 2020/7/20
 */
public class Lc0628{

    /**
     * 线性扫描
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {
                // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
    /**
     * 排序
     * 1.如果没有负数, 那么肯定是后面三个元素的乘积最大
     * 2.如果有负数, 那么肯定是最小的两个负数的乘积,再乘以最大的一个数,他们的乘积最大
     * -6 -5 -4 -3 -2 -1 0 1 2
     * @param nums
     * @return
     */
    public static int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = Math.max(nums[0] * nums[1] * nums[len-1],nums[len-1] * nums[len-2] * nums[len-3]);
        return max;
    }

    public static void main(String[] args){
        System.out.println(maximumProduct(new int[]{-6,-5,-4,-3,-2,-1,0,1,2}));
    }
}
