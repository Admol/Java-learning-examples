package com.admol.algorithm.leetcode.simple.math;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:    输入: 4   输出: 2
 * 示例 2:    输入: 8   输出: 2 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 * @author : admol
 * @Date : 2020/6/15
 */
public class Lc0069{
    /**
     * 二分查找方案
     * 时间复杂度：O(logx)，即为二分查找需要的次数。
     * 空间复杂度：O(1)。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        int left = 0;
        int right = x;
        while(left +1 < right){
            // 计算中位数
            int mid = ((right-left) >> 1) + left;
            // 计算乘积
            long product = (long)mid * mid ;
            if(product == x){
                // 相等,直接返回
                return mid;
            }
            if(product < x){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
    /**
     * 调用API
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }

    public static void main(String[] args){
//        System.out.println(mySqrt(0));
//        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(6));
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(8));
    }
}
