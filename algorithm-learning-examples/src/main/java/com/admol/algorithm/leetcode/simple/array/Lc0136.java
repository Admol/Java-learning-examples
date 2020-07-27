package com.admol.algorithm.leetcode.simple.array;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]      输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]  输出: 4
 * 链接：https://leetcode-cn.com/problems/single-number
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0136{

    /**
     * 异或运算规律:
     * 1. 相同则为0, 不同则为1,  111 ^ 100 = 011
     * 2. 任何数于0异或为任何数 0 ^ n => n
     * 3. 相同的数异或为0: n ^ n => 0
     * 4. 交换律：a ^ b ^ c 等价于 a ^ c ^ b
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = (res ^ nums[i]);
        }
        return res;
    }

    /**
     * 比较挫的一种做法, 先排序, 再判断
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        // 1. 升序排序
        Arrays.sort(nums);
        // 2. 校验相邻的两个数是否相等, 想到步长+2
        for(int i = 0; i < nums.length-1; i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args){
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1,3,1,-1,3}));
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{2,2,4,4,1,3,1}));
    }
}
