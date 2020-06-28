package com.admol.algorithm.leetcode.simple;

/**
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:     输入: "A"      输出: 1
 * 示例 2:    输入: "AB"     输出: 28
 * 示例 3:    输入: "ZY"     输出: 701
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * @author : admol
 * @Date : 2020/6/28
 */
public class Lc0171{

    /**
     *
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        //1.确定字符串与数字映射关系
        //A -> 1 , Z -> 26 'A'=65
        if(s == null){
            return -1;
        }
        char[] chars = s.toCharArray();
        int sum = 0;
        // 代表位, 从最低位开始,
        // 第0位:26的0次方+num,第1位:26的1次方+num,第2位:26的2次方+num ... 统计所有位的和
        int carry = 0;
        for(int i = chars.length - 1; i >= 0; i--){
            // sum += num * 26的n次方
            sum += (chars[i]-64) * Math.pow(26,carry);
            // 进位
            carry++;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("B"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("AAA"));
    }
}
