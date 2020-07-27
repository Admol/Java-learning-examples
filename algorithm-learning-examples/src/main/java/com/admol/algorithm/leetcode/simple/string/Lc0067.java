package com.admol.algorithm.leetcode.simple.string;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:    输入: a = "11", b = "1"        输出: "100"
 * 示例 2:    输入: a = "1010", b = "1011"   输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * @author : admol
 * @Date : 2020/6/12
 */
public class Lc0067{

    /**
     *时间复杂度为 O(MAX(N,M))
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        // 最长的字符串
        int lenA = a.length();
        int lenB = b.length();
        if(lenA < lenB){
            // 目的是为了前面让长的字符串入参在前
            return addBinary(b,a);
        }
        // 结果字符串
        StringBuilder sb = new StringBuilder();
        // 进位标识, 决定计算时是否加1
        int carry = 0;
        // 1.遍历短的字符串
        for(int i = lenA - 1; i >= 0; i--){
            // 取尾巴数
            int c1 = a.charAt(--lenA) == '1'? 1 : 0;
            // 取尾巴数
            int c2 = --lenB >= 0 ? b.charAt(lenB) == '1'? 1 : 0 : 0;
            // 计算每个位相加的和, 并考虑进位加一
            int value = c1 + c2 + carry;
            // 取每个位的和与2的余数, 0=>0,1=>1,2=>0,3=>1
            // sb.append(value % 2);
            sb.append(c1 ^ c2 ^ carry);
            carry = 0;
            if(value >= 2){
                // 大于2,说明下次需要进位+1
                carry = 1;
            }
        }
        if(carry == 1){
            // 可能会多出一位
            sb.append(1);
        }
        // 字符串反转
        sb.reverse();
        return sb.toString();
    }

    /**
     * 使用JAVA API
     * 时间复杂度为 O(N+M)
     * 在 Java 中，该方法受输入字符串 a 和 b 的长度限制。字符串长度太大时，不能将其转换为 Integer，Long 或者 BigInteger 类型。
     * 33 位 1，不能转换为 Integer。
     * 65 位 1，不能转换为 Long。
     * 500000001 位 1，不能转换为 BigInteger
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
    }

    public static void main(String[] args){
//        System.out.println(addBinary("1100","11"));
//        System.out.println(addBinary("11","11"));
//        System.out.println(addBinary("10","1"));
        System.out.println(addBinary("101111","10"));
        System.out.println(addBinary("11","1"));

    }
}
