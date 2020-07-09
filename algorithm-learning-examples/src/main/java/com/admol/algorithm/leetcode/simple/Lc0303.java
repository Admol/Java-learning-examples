package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * @author : admol
 * @Date : 2020/7/8
 */
public class Lc0303{

    public static void main(String[] args){
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
        NumArray1 numArray1 = new NumArray1(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray1.sumRange(0,2));
        System.out.println(numArray1.sumRange(2,5));
        System.out.println(numArray1.sumRange(0,5));
    }

    /**
     * 空间复杂度：O(n)
     */
    static class NumArray1 {

        private int[] sum;

        /**
         * 缓存
         * @param nums
         */
        public NumArray1(int[] nums) {
            sum = new int[nums.length + 1];
            //预先计算数字 0 到 k的累积和
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    static class NumArray {

        int[] array;
        public NumArray(int[] nums) {
            array = nums;
        }

        /**
         * 循环求和
         * @param i
         * @param j
         * @return
         */
        public int sumRange(int i, int j) {
            int sum =0;
            // 1.循环求和
            while(i<=j && i<array.length){
                sum += array[i];
                i++;
            }
            return sum;
        }
    }
}
