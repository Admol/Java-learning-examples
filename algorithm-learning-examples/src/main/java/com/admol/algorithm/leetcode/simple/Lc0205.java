package com.admol.algorithm.leetcode.simple;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * @author : admol
 * @Date : 2020/7/1
 */
public class Lc0205{

    /**
     * 同构, 输入: s = "egg", t = "add" 即都是ABB的结构
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s,String t) {
        if (s.length() == 1) {
            return true;
        }
        // 对比 s-->t 和 t-->s 映射关系
        return helper(s,t) && helper(t,s);
    }

    private static boolean helper(String s,String t){
        // 1.关系映射
        HashMap<Character,Character> map = new HashMap<>(128);
        for(int i = 0; i < s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            // 1. 查找关系映射
            Character c = map.get(s1);
            if(c == null){
                // 2.建立映射关系
                map.put(s1,t1);
            }else {
                // 比对映射关系是否正确
                if(c != t1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isIsomorphic("ab","aa"));
        System.out.println(isIsomorphic("ab","ca"));
        System.out.println(isIsomorphic("add","ebb"));
        System.out.println(isIsomorphic("add","eba"));
    }
}
