package com.admol.algorithm.leetcode.simple;

/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * 输入: 218
 * 输出: false
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0231{
    /**
     * 位运算：去除二进制中最右边的 1
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if(n < 1){
            return false;
        }
        // 小技巧: n & (n-1) , 可以去除二进制中最右边的 1 ,
        // 因为n-1计算实际上是借原二进制位上最后的一个1, 会把它设为0, 如果其它更高位是1的话, 还会保持不变
        // 理论上如果是2的幂的话, 如果把最后一个1设为了0 , 那相当于整个数就变为了0了, 所以最后判断结果是否为0即可
        // 5 & (5-1) ==>
        //        5:  0000 0101
        //        4:  0000 0011
        //5 & (5-1):  0000 0001  ==> 1
        // 最后结果得到1, 不为0, 所以不是2的幂
        return (n & (n-1)) == 0;
    }

    /**
     * 位运算, 获取最右边的 1
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo5(int n) {
        if(n < 1){
            return false;
        }
        // 小技巧: n & (-n)可以获取二进制中最右边的1, 比如n=5: 5的二进制位:0101, -5的二进制位为取反+1:01010+1 ==> 11011
        // 5 & (-5) ==>
        //       5:  0000 0101
        //      -5:  1111 1011
        //5 & (-5):  0000 0001
        // 如果n是2的幂, 那么n的二进制位肯定只有一个1, 用 n & (-n) 肯定最后获取到的也是唯一的一个1, 所以最后判断是否 n & (-n) ==n 即可
        return (n & (-n)) == n;
    }
    /**
     * 利用 Lc0191 统计二进制1的位数
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo4(int n) {
        if(n < 1){
            return false;
        }
        int count  = 0;
        while(n != 0){
            // 这里n会自动被转换成二进制位来标识, 比如n=8, 级判断的是(1000 & 0001) != 0
            // 也就是判断最低位是否为1
            if((n & 1) != 0){
                count++;
            }
            // 然后无符号向右移动一位
            n = n >>> 1;
        }
        return count == 1;
    }
    /**
     * 二进制字符串, 统计1的个数
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo3(int n) {
        if(n < 1){
            return false;
        }
        int oneCount = 0;
        String str = Integer.toBinaryString(n);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                oneCount++;
            }
        }
        return oneCount == 1;
    }

    /**
     * 首先将数字转换成二进制位, 然后统计二进制位上面1的个数
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo2(int n) {
        if(n < 1){
            return false;
        }
        return 1 == Integer.bitCount(n);
    }

    /**
     * 简单粗暴的写法
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo1(int n) {
        if(n < 1){
            return false;
        }
        int i = 0;
        int res = 0;
        while(res < 1){
            res = power(n,i);
            if(res == 0){
                return true;
            }
            i++;
        }
        return false;
    }

    private static int power(int n,int i){
        int sum  = 1 << i;
        if(sum== n){
            return 0;
        } else if(sum < n){
            return -1;
        }else {
            return 1;
        }
    }

    public static void main(String[] args){
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(5));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(5 & (-5));
        System.out.println(0b1010 & 0b1011);
    }
}
