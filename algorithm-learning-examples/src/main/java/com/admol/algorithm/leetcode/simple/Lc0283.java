package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0283{
    /**
     * 双指针
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        // 1.i指针寻找不为0
        int index = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] !=0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i = index; i < nums.length ; i++){
            nums[i] = 0;
        }
        Arrays.stream(nums).forEach(System.out::print);
    }


    public static void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void moveZeroes1(int[] nums) {
        for(int i = 0; i < nums.length ; i++){
            int j = i+1;
            while(j<nums.length){
                if(nums[i] ==0 && nums[j] != 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    if(j == nums.length -1){
                        return;
                    }
                    break;
                }
                j++;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void main(String[] args){
        moveZeroes1(new int[]{2,1});
        System.out.println();
        moveZeroes1(new int[]{0,1,2,0,3});
        System.out.println();
        moveZeroes2(new int[]{2,1});
        System.out.println();
        moveZeroes2(new int[]{0,1,2,0,3});
    }
}
