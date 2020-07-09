package com.admol.algorithm.leetcode.simple;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 链接：https://leetcode-cn.com/problems/missing-number
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0268{

    /**
     * 异或运算规律:
     * 1. 相同则为0, 不同则为1,  111 ^ 100 = 011
     * 2. 任何数于0异或为任何数 0 ^ n => n
     * 3. 相同的数异或为0: n ^ n => 0
     * 4. 交换律：a ^ b ^ c 等价于 a ^ c ^ b
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res ^= (i ^ nums[i]);
        }
        return res ^ nums.length;
    }

    public static void main(String[] args){
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1,3}));
        System.out.println(missingNumber(new int[]{0,1,2,3,4,6}));
        System.out.println(missingNumber(new int[]{0,1,2,3,4,5}));
        System.out.println(3 ^ 6);
    }
}
