package com.admol.algorithm.leetcode.simple;

/**
 * 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 示例 1:
 * 输入: 16
 * 输出: true
 * 示例 2:
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * @author : admol
 * @Date : 2020/7/9
 */
public class Lc0342{
    /**
     * 数学运算:
     * https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode/
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
    }
    /**
     * 位运算
     * @param num
     * @return
     */
    public static boolean isPowerOfFour2(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
    public static boolean isPowerOfFour1(int num) {
        return Integer.toString(num,4).matches("^10*$");
    }

    public static void main(String[] args){
        System.out.println(Integer.toString(1,4));
        System.out.println(Integer.toString(4,4));
        System.out.println(Integer.toString(16,4));
        System.out.println(Integer.toString(64,4));
        System.out.println(Integer.toString(256,4));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(16));
    }
}
