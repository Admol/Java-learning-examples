package com.admol.algorithm.leetcode.simple;

/**
 * xcel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:     输入: 1   输出: "A"
 * 示例 2:    输入: 28  输出: "AB"
 * 示例 3:    输入: 701 输出: "ZY"
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0168{
    /**
     * A => 65  Z => 90
     * 53 => BA
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        if(n < 1){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            // 求余数
            int remainder = n % 26 == 0 ? 26 : n % 26 ;
            // 1->26  转换成A-Z ascii 65->90, 所以要加64
            sb.insert(0,(char) (remainder+64));
            n -= remainder;
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(53));
        System.out.println(convertToTitle(81));
    }
}
