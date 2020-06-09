package com.admol.algorithm.leetcode.simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]   输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * @author : admol
 * @Date : 2020/6/9
 */
public class Lc0014{

    /**
     * 注意题目要求的只是查找公共前缀, 而不是公共部分
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        boolean flag = true;
        while(flag){
            //1. 依次取出每次字符
            for(int i = 0; i < strs.length; i++){
                String s = strs[i];
                if(index <= s.length()-1){
                    if(s == null  || s.length() == 0){
                        return "";
                    }
                    if(strs[0].charAt(index) != s.charAt(index)){
                        flag = false;
                        break;
                    }
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(strs[0].charAt(index));
            }
            index++;
        }
        return sb.toString();
    }

    /**
     * 官方方案
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 1.取数组中的第一个字符串
        String prefix = strs[0];
        // 2.从第二个字符串开始循环
        for (int i = 1; i < strs.length; i++){
            //3.判断从第二个字符串是否有包含第一个字符串
            while (strs[i].indexOf(prefix) != 0) {
                //4.如果没有, 则将第一个字符串的最后一个字符截取掉, 再次循环判断, 知道为空退出
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{""};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"","b"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"",""};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"c","c"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"aa","aa"};
        System.out.println(longestCommonPrefix(strs));

        strs = new String[]{"aa",""};
        System.out.println(longestCommonPrefix2(strs));
    }
}
