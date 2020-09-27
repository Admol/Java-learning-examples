package com.admol.algorithm.leetcode.simple.string;

/**
 * 415. 字符串相加
 * @author : admol
 * @Date : 2020/8/20
 */
public class Lc0415{

    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] ans = new int[Math.max(n1,n2)+1];
        int carry = 0;
        for(int i = ans.length-1; i >= 0; i--){
            int x = (n1 > 0 ? num1.charAt(n1-1) - '0' : 0);
            int y = (n2 > 0 ? num2.charAt(n2-1) - '0' : 0);
            int sum = x + y + carry;
            ans[i] = sum % 10;
            carry = sum / 10;
            n1--;
            n2--;
        }
        int begin = ans[0] == 0 ? 1 : 0;
        StringBuilder res = new StringBuilder();
        for(; begin < ans.length; begin++){
            res.append(ans[begin]) ;
        }
        return res.toString();
    }
    /**
     * 字符串接收结果
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings1(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(n1 > 0 || n2 > 0 || carry > 0){
            int x = (n1 > 0 ? num1.charAt(--n1) - '0' : 0);
            int y = n2 > 0 ? num2.charAt(--n2) - '0' : 0;
            int sum = x + y + carry;
            sb.insert(0,sum % 10);
            carry = sum / 10;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Lc0415().addStrings1("999","999"));
    }
}
