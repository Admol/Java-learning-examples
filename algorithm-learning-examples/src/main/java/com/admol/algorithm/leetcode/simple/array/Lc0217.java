package com.admol.algorithm.leetcode.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]    输出: true
 * 示例 2:
 * 输入: [1,2,3,4]    输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]    输出: true
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0217{
    /**
     *  时间复杂度 : O(n)
     * 空间复杂度 : O(n)
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length < 2){
            // 一个元素肯定没有重复的
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        if(nums.length < 2){
            // 一个元素肯定没有重复的
            return false;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4,1}));
        System.out.println(containsDuplicate1(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate1(new int[]{1,2,3,4,1}));
    }
}
