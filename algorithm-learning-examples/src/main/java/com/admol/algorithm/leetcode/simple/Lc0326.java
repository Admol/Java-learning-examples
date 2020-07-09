package com.admol.algorithm.leetcode.simple;

/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27   输出: true
 * 示例 2:
 * 输入: 0    输出: false
 * 示例 3:
 * 输入: 9    输出: true
 * 示例 4:
 * 输入: 45   输出: false
 * 进阶： 你能不使用循环或者递归来完成本题吗？
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * @author : admol
 * @Date : 2020/7/9
 */
public class Lc0326{

    /**
     * int的最大值是:2147483647
     * 3 的幂最大是:1162261467
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    /**
     * 转换成对应的3进制,
     * 3的0次方 = 1            10
     * 3的1次方 = 3            10
     * 3的2次方 = 9            100
     * 3的3次方 = 27           1000
     * 3的4次方 = 81           10000
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        System.out.println(Integer.toString(n,3));
        // 转换成对应的3进制, 3=>10,9=>100,27=>1000
        // 正则匹配是否以1 ^1 开头，后跟 0 或 多个 0 0* 并且不包含任何其他值 $
        return Integer.toString(n, 3).matches("^10*$");
    }
    /**
     * 3的幂; 循环
     * @param n
     * @return
     */
    public static boolean isPowerOfThree1(int n) {
        while(n > 0 && n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args){
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(12));
        System.out.println(isPowerOfThree(27));
    }
}
