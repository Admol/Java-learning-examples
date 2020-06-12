package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]  输出: [1,2,4]     解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1] 输出: [4,3,2,2]  解释: 输入数组表示数字 4321。
 * @author : admol
 * @Date : 2020/6/12
 */
public class Lc0066{
    /**
     * 需要考虑到增位的情况, 比如[9,9]的情况
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        // 1.个位数小于9, 直接+1返回
        if(digits[digits.length - 1] < 9){
            digits[digits.length - 1] = digits[digits.length - 1]+1;
            // 前面的数字不会再变了, 可以直接退出
            return digits;
        }
        // 2.个位数大于9, 进行进位+1并且个位数赋值为0
        digits[digits.length - 1] = 0;
        int i = digits.length - 2;
        for( ; i >= 0; i--){
            // 当前遍历位置的数
            int num = digits[i];
            if(num + 1 <= 9){
                // 相加后小于等于9, 直接在原位置覆盖
                digits[i] = num+1;
                // 前面的数字不会再变了, 可以直接退出
                return digits;
            }
            // 需要进位处理
            digits[i] = 0;
        }
        // 处理全是9的情况,比如[9,9,9]
        if(i <= 0){
            // 增加位置
            int[] newArray = new int[digits.length+1];
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }

    /**
     * 真踏马简洁
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args){
        Arrays.stream(plusOne(new int[]{1,2,3,4,5})).forEach(i-> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(plusOne(new int[]{5})).forEach(i-> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(plusOne(new int[]{9})).forEach(i-> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(plusOne(new int[]{1,9})).forEach(i-> System.out.print(i + " "));
    }
}
