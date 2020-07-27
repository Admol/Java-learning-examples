package com.admol.algorithm.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 5, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0167{


    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while(left <= right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }else if(sum < target){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }


    public static int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int a = numbers[i];
            if(a > target){
                break;
            }
            int diff = target - a;
            // 从 i+1开始查询diff在numbers中的位置
            int end = find(numbers,i+1,diff);
            if(end != -1){
                res[0] = i+1;
                res[1] = end+1;
            }
        }
        return res;
    }

    /**
     * {2, 5, 7, 11, 15}
     * @param numbers
     * @param i
     * @param diff
     * @return
     */
    private static int find(int[] numbers,int i,int diff){
        // 二分查找
        int left = i;
        int right = numbers.length - 1;
        while(left <= right){
            int mid = (right - left) /2 + left;
            if(numbers[mid] == diff){
                return mid;
            }else if(numbers[mid] < diff){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int[] nums = new int[]{2, 5, 7, 11, 15};
        Arrays.stream(twoSum(nums,9)).forEach(System.out::print);
        System.out.println();
        nums = new int[]{2, 5, 7, 11, 15};
        Arrays.stream(twoSum(nums,16)).forEach(System.out::print);
        System.out.println();
        nums = new int[]{2,3, 5};
        nums = new int[]{-1,0};
        Arrays.stream(twoSum(nums,-1)).forEach(System.out::print);
        System.out.println();
        nums = new int[]{2, 5, 7, 11, 15};
        Arrays.stream(twoSum(nums,15)).forEach(System.out::print);
        System.out.println();
    }
}
