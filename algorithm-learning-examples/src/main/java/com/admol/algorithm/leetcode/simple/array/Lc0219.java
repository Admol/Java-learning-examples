package com.admol.algorithm.leetcode.simple.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3  输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1  输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2  输出: false
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0219{
    /**
     * 维护一个指定最大容量k大小的hashset, 向前滑动, 判断这个容量里面有没有重复值即可
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums,int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    /**
     * 双指针遍历
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= i+k && j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1},1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
}
