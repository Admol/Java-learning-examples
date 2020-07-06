package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * 链接：https://leetcode-cn.com/problems/add-digits
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0258{
    /**
     * 数学
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        // 或者一句话搞定
        // return (num - 1) % 9 + 1;
        //X = 100*a + 10*b + c = 99*a + 9*b + (a+b+c)；所以对9取余即可
        if(num==0){
            return 0;
        }
        if(num%9==0){
            return 9;
        }else{
            return num%9;
        }
    }
    /**
     * 递归
     * @param num
     * @return
     */
    public static int addDigits1(int num) {
        if(num < 10){
            return num;
        }
        // 各个位数的和
        int sum =0;
        while(num != 0){
            // 1.加上个位数
            sum += (num % 10);
            // 2.去掉个位数
            num /= 10;
        }
        // 递归继续计算
        return addDigits(sum);
    }

    public static void main(String[] args){
        System.out.println(addDigits(38));
        System.out.println(addDigits(99));
    }


}
