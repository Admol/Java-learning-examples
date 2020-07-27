package com.admol.algorithm.leetcode.simple.math;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 示例 1:
 * 输入: 6    输出: true    解释: 6 = 2 × 3
 * 示例 2:
 * 输入: 8    输出: true    解释: 8 = 2 × 2 × 2
 * 示例 3:
 * 输入: 14   输出: false   解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0263{

    /**
     * 只包含质因数 2, 3, 5 的正整数, 所以这个数必须要是2的X次方+3的Y次方+5的Z次方
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        if(num <= 0){
            // 负数质因数也有负数
            return false;
        }
        int[] factors = new int[]{2,3,5};
        for(int factor : factors){
            // 依次求余, 如果余数不为0, 继续下一个进行整除
            while(num % factor == 0){
                num /= factor;
            }
        }
        return num == 1;
    }

    public static void main(String[] args){
        System.out.println(isUgly(0));
    }
}
