package com.admol.algorithm.leetcode.simple;


/**
 * 第三大的数
 * 标签:数组
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * @author : admol
 * @Date : 2020/7/9
 */
public class Lc0414{


    public static int thirdMax(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 假设数组第一个为最大值
        Integer max = nums[0];
        Integer secondMax = null;
        Integer thirdMax = null;
        for(int i = 1; i < len; i++){
            int curr = nums[i];
            if(curr == max){
                // 1.遇到相等的直接跳过
                continue;
            }
            if(curr > max){
                // 2.更新最大值
                thirdMax = secondMax;
                secondMax = max;
                max = curr;
                continue;
            }
            // 后面的情况为curr < max
            if(secondMax == null){
                // 3.第一次赋值secondMax
                secondMax = curr;
                continue;
            }

            if(curr == secondMax){
                continue;
            }
            if(curr > secondMax){
                // 5.遇到的值比第二大值要大, 更新第二第三大的值
                thirdMax = secondMax;
                secondMax = curr;
            }else {
                // curr < secondMax;
                // 从顺序:curr thirdMax curr  secondMax max 中选择第三大的值
                thirdMax = (thirdMax == null) ? curr : Math.max(thirdMax,curr);
            }
        }
        return thirdMax == null ? max : thirdMax;
    }


    public static void main(String[] args){
//        System.out.println(thirdMax(new int[]{1,-1,2}));
//        System.out.println(thirdMax(new int[]{1}));
//        System.out.println(thirdMax(new int[]{6,2}));
//        System.out.println(thirdMax(new int[]{1,2}));
        System.out.println(thirdMax(new int[]{1,2,-2147483648}));
        System.out.println(thirdMax(new int[]{6,5,5}));
        System.out.println(thirdMax(new int[]{1,1,2}));
        System.out.println(thirdMax(new int[]{3,2,1}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax(new int[]{1,2,6,4,5,5}));
        System.out.println(thirdMax(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
    }
}
