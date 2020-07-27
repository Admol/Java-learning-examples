package com.admol.algorithm.leetcode.simple.string;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * @author : admol
 * @Date : 2020/7/3
 */
public class Lc0242{

    /**
     * 只包含小写字母的解法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        // 26个小写字符一一映射到长度为26的数组中
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++){
            // s字符串中字符映射++
            counter[s.charAt(i) - 'a']++ ;
            counter[t.charAt(i) - 'a']-- ;
        }
        for(int num : counter){
            if(num != 0){
                // 统计的字符次数有差异
                return false;
            }
        }
        return true;
    }

    /**
     * 排序后比较字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            // 长度不相等, 肯定不是同构字符串
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    public static void main(String[] args){

    }
}
