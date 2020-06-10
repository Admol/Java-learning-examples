package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"    输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"   输出: -1
 * @author : admol
 * @Date : 2020/6/10
 */
public class Lc0028{
    /**
     *
     * @param haystack  输入: haystack = "hello"
     * @param needle    输入: needle = "ll"
     * @return  输出: 2
     */
    public static int strStr(String haystack,String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        if("".equals(needle)){
            return 0;
        }
        //1. 第一种办法 直接调用api
        //haystack.indexOf(needle);

        char[] hay = haystack.toCharArray();
        char[] nee =  needle.toCharArray();

        for(int i = 0; i < hay.length; i++){
            if(hay[i] == nee[0]){
                int j = i + 1;
                int end = j + nee.length - 1;
                for (int k = 1; j < end && j < hay.length && hay[j] == nee[k]; ){
                    j++;
                    k++;
                }
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0){
            return 0;
        }

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)){
                ++pn;
            }

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L){
                return pn - L;
            }

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        if("".equals(needle)){
            return 0;
        }
        //1. 第一种办法 直接调用api
        //haystack.indexOf(needle);

        char[] hay = haystack.toCharArray();
        char[] nee =  needle.toCharArray();

        for(int i = 0; i < hay.length; i++){
            if(hay[i] == nee[0]){
                // 寻找到第一个字符相等的
                for(int j = 0; j < nee.length && (i+j)< hay.length; j++){
                    if(nee[j] != hay[i+j]){
                        //退出继续执行i循环
                        break;
                    }
                    if(j == nee.length-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println("hello".indexOf("ll"));
        System.out.println(strStr("hello","l"));
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("hello","x"));
        System.out.println(strStr("","x"));
        System.out.println(strStr("hello","helloxx"));
        System.out.println(strStr("hello","hello"));
        System.out.println(strStr("mississippi","issipi"));
        System.out.println(strStr("miissipi","issipi"));
    }
}
