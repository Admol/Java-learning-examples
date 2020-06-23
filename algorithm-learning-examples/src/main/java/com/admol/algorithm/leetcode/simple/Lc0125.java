package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"    删掉空格和逗号  AmanaplanacanalPanama
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 *
 * @author : admol
 * @Date : 2020/6/23
 */
public class Lc0125{


    /**
     * 双指针版本
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        // 1.全部转换成大写字母
        char[] chars = s.toUpperCase().toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left < right){
            char head = chars[left];
            if(!Character.isLetterOrDigit(head)){
                left++;
                continue;
            }
            char tail = chars[right];
            if(!Character.isLetterOrDigit(tail)){
                right--;
                continue;
            }
            if(head != tail){
                return false;
            }
            // 左指针右移
            left++;
            // 右指针左移
            right--;
        }
        return true;
    }
    /**
     * ascii 字符范围 A-Z 65-90  a-z 97-122
     * 执行用时：3 ms, 在所有 Java 提交中击败了92.41%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了7.14%的用户
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        if(s == null){
            return false;
        }
        // 1.全部转换成大写字母
        char[] chars = s.toUpperCase().toCharArray();
        int j = chars.length - 1;
        // 2.双指针, 从头遍历的指针
        for(int i = 0; i < chars.length; i++){
            char head = chars[i];
            if(!Character.isLetterOrDigit(head)){
                // 头指针, 不是字母和数字就跳过
                continue;
            }
            if(i >= j){
                return true;
            }
            for(; j >= 0; ){
                // 尾指针
                char tailChar = chars[j];
                if(!Character.isLetterOrDigit(tailChar)){
                    // 尾指针, 不是字母和数字就跳过
                    j--;
                    continue;
                }
                if(head != tailChar){
                    // 说明不相等
                    return false;
                }
                j--;
                break;
            }
        }
        return true;
    }

    /**
     * ascii 字符范围 A-Z 65-90  0-9 48-57
     * @param c
     */
    private static boolean isAlphabet(char c){

        if((c>='A' && c<='Z') || (c>='0' && c<= '9')){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
//        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
    }
}
