package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 * 输入: "Hello World"    输出: 5
 * @author : admol
 * @Date : 2020/6/12
 */
public class Lc0058{
    /**
     * 思路: 从后面忘前面遍历非空字符, 遇到第一个空格为止
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int len = 0;
        if(s == null){
            return len;
        }
        char[] chars = s.toCharArray();
        for(int i = chars.length - 1; i >= 0; i--){
            if(len == 0 && chars[i] == ' '){
                // 尾巴是空格, 不统计, 继续遍历
                continue;
            }
            if(len > 0 && chars[i] == ' '){
                // 已经变量到了单词, 切遇到了空格
                break;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello World "));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("    "));
    }
}
