package com.admol.algorithm.leetcode.simple;

/**
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:    输入: 3    输出: 0   解释: 3! = 6, 尾数中没有零。
 * 示例 2:    输入: 5    输出: 1   解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @author : admol
 * @Date : 2020/6/28
 */
public class Lc0172{
    /**
     * 5! = 5*4*3*2*1 = 120;
     * 9! = 9*8*7*6*5*4*3*2*1 = 362880;
     * 10! = (5*2)*9*8*7*6*5*4*3*2*1 = 3628800;
     * 14! = 14*13*12*11*(5*2)*9*8*7*6*5*4*3*2*1= 87178291200;
     * 15! = (5*3)*14*13*12*11*(5*2)*9*8*7*6*5*4*3*2*1 = 1307674368000;
     * 20! = 5*4*19*18*7*16*(5*3)*14*13*12*11*(5*2)*9*8*7*6*5*4*3*2*1 ;
     * 25! = (5*5)*24*23*22*21*(5*4)*19*18*7*16*(5*3)*14*13*12*11*(5*2)*9*8*7*6*5*4*3*2*1 ;
     * 30! = (5*6)*...*(5*5)*...*(5*4)*...*(5*3)*...*(5*2)*...*5*4*3*2*1 ;
     * 50! = (5*5*2)...5*9..5*8...5*7...*(5*6)...(5*5)...(5*4)...(5*3)...(5*2)...5*4*3*2*1 ;
     * 通过规律可以发现, 实际经过拆分可以直接统计5的个数就可以了, 所以只需要不断的整除5, 直到结果为0为止
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    public static void main(String[] args){
        System.out.println("1: "+trailingZeroes(1));
        System.out.println("5: "+trailingZeroes(5));
        System.out.println("9: "+trailingZeroes(9));
        System.out.println("10: "+trailingZeroes(10));
        System.out.println("14: "+trailingZeroes(14));
        System.out.println("15: "+trailingZeroes(15));
        System.out.println("20: "+trailingZeroes(20));
        System.out.println("30: "+trailingZeroes(30));
        System.out.println("40: "+trailingZeroes(40));
        System.out.println("50: "+trailingZeroes(50));
        System.out.println("50: "+trailingZeroes(100));
    }
}
