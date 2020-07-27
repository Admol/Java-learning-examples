package com.admol.algorithm.leetcode.simple.array;


/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:    输入: [1,3,5,6], 5     输出: 2
 * 示例 2:    输入: [1,3,5,6], 2     输出: 1
 * 示例 3:    输入: [1,3,5,6], 7     输出: 4
 * 示例 4:    输入: [1,3,5,6], 0     输出: 0
 *
 * 思考: 因为有序, 可以采用二分查找的思想来查找位置
 * 扩展1. 如果需要支持逆序排序的数组怎么办?  确定目标值比中间值大还是小之后, 大,继续从左段查找,小,继续从右段查找
 * @author : admol
 * @Date : 2020/6/11
 */
public class Lc0035{
    /**
     *
     * 输入: [1,3,5,6], 5     输出: 2
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if(nums.length < 1){
            // 空数组, 会被插入到第一个位置
            return 0;
        }
        int len = nums.length;
        int r = binarySearch(nums,0,len-1,target);
        return r;
    }
    /**
     * 二分查找目标值索引位置
     * @param nums  [1,3,5,6]
     * @param begin
     * @param end
     * @param target
     * @return 查找目标值索引位置, 如果目标值不存在于数组中, 返回它将会被按顺序插入的位置
     */
    private static int binarySearch(int[] nums,int begin,int end,int target){
        // 1.确定中间位置, 这样计算的目的是防止溢出, 如果begin和end都非常大的话,是有可能溢出的
        int mid = (end - begin) / 2 + begin;
        if(nums[mid] == target){
            return mid;
        }
        // 2.起始位置相等, 说明还没有找到目标值
        if(end == begin){
            //原二分查找, 如果没有找到位置返回-1
            //return -1;
            //最后还是没有找到目标值的位置, 确定目标数字是应该插在摇摆不定的左边还是右边
            return target > nums[begin] ? begin + 1: begin;
        }
        // 3.目标值比中间值要小
        if(target < nums[mid]){
            //在数组的开始位置至中间位置段继续查找
            return binarySearch(nums,begin,mid,target);
        }
        // 4.目标值比中间值要大  在数组的中间位置至结束位置段继续查找
        return binarySearch(nums,mid+1,end,target);
    }

    public static void main(String[] args){
        int[] nums = {1,2,4,5,6};
        System.out.println(searchInsert(nums,3));
        nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,4));
        nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,7));
        nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,0));
        nums = new int[]{1};
        System.out.println(searchInsert(nums,0));
        System.out.println(searchInsert(nums,2));
    }
}
