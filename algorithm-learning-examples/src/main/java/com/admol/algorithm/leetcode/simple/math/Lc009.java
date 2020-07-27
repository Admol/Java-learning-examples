package com.admol.algorithm.leetcode.simple.math;

/**
 *判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 示例 1:
 * 输入: 121 输出: true
 * 示例 2:
 * 输入: -121 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能否将整数转为字符串来解决这个问题吗？
 * @author : admol
 * @Date : 2020/6/2
 */
public class Lc009{
    /**
     * 解题思路:
     * 1.用Lc007的办法, 将数字反转, 并比对
     * @see Lc007
     *
     * 2.左右两边的数字进行比较, 最右边的余数很好拿到
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        // 0 或者仅个位数
        if(x >= 0 && x % 10 == x){
            return true;
        }
        // 负数或者个位数是0的不是回文数
        if(x < 0 || x % 10 == 0){
            return false;
        }

        // 计算x的最高位数, 如123 就是100
        long count = 10;
        while(count <= x){
            count = count * 10;
        }
        count /= 10;
//        System.out.println("x:"+x+"的总位数:"+count);

        while(x!=0 && count !=0){
            // 最右边的余数
            int right = x % 10;
            // 最左边的数
            long left = x / count % 10;
            // System.out.println("左边:"+left+" 右边:"+right);
            if(left != right){
                return false;
            }
            // 每次的余数不要了
            x /= 10;
            // 左右都向中间移动移动, 相当于位数少两位
            count /= 100;
        }
        return true;
    }

    /**
     * 通过字符串的方式来校验回文
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        // 0 或者仅个位数
        if(x >= 0 && x % 10 == x){
            return true;
        }
        // 负数或者个位数是0的不是回文数
        if(x < 0 || x % 10 == 0){
            return false;
        }
        String str = String.valueOf(x);
        int length = str.toCharArray().length;
        // 通过奇偶数来确定中位数
        int end = length % 2 == 0 ? length / 2 : length / 2 + 1;
        char[] chars = str.toCharArray();
        for(int i = 0; i < end; i++){
            if(chars[i] != chars[length-i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        // 测试用例数
        int[] ints = {-1,0,5,11,1221,5678,100000000,1000000001};
        for(int i = 0; i < ints.length; i++){
            System.out.println(ints[i]+ " 判断是否是回文: "+ isPalindrome(ints[i]));
        }
        System.out.println("字符串转换方式======================");
        for(int i = 0; i < ints.length; i++){
            System.out.println(ints[i]+ " 判断是否是回文: "+ isPalindrome2(ints[i]));
        }
    }


}
