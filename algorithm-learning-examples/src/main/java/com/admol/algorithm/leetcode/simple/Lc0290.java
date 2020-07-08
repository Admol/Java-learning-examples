package com.admol.algorithm.leetcode.simple;

import java.util.HashMap;

/**
 * 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"    输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"    输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"    输出: false
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"    输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0290{
    /**
     *
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] arrays = str.split(" ");
        HashMap<Character,String> mapStr = new HashMap();
        if(pattern.length() != arrays.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            if(!mapStr.containsKey(pattern.charAt(i))){
                if(mapStr.containsValue(arrays[i])){
                    return false;
                }
                // 保存映射关系
                mapStr.put(pattern.charAt(i),arrays[i]);
            }else{
                // 1.查询规则对应的字符串
                String m = mapStr.get(pattern.charAt(i));
                if(!m.equals(arrays[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(wordPattern("abc","dog cat cat"));
        System.out.println(wordPattern("aba","dog cat cat"));
        System.out.println(wordPattern("aba","cat cat cat"));
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat doga"));
    }
}
