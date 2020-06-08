package com.admol.algorithm.leetcode.simple;

import java.util.*;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
     * 输入: "III" 输出: 3
 * 示例 2:
     * 输入: "IV"  输出: 4
 * 示例 3:
     * 输入: "IX"  输出: 9
 * 示例 4:
     * 输入: "LVIII" 输出: 58  解释: L = 50, V= 5, III = 3.
 * 示例 5:
     * 输入: "MCMXCIV" 输出: 1994 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author : admol
 * @Date : 2020/6/7
 */
public class Lc0013{


    public static int romanToInt(String s) {
        if(s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int sum  = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] =='I' && i+1 < chars.length && (chars[i+1] == 'V' || chars[i+1] == 'X')){
                sum += (getValueByChar(chars[i+1])-getValueByChar(chars[i]));
                i++;
                continue;
            }
            if(chars[i] == 'X' && i+1 < chars.length && (chars[i+1] == 'L' || chars[i+1] == 'C')){
                sum += (getValueByChar(chars[i+1])-getValueByChar(chars[i]));
                i++;
                continue;
            }
            if(chars[i] == 'C' && i+1 < chars.length && (chars[i+1] == 'D' || chars[i+1] == 'M')){
                sum += (getValueByChar(chars[i+1])-getValueByChar(chars[i]));
                i++;
                continue;
            }
            int value = getValueByChar(chars[i]);
            sum += value;
        }
        return sum;
    }

    private static int getValueByChar(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }


    /**
     * 使用HashMap String的方式求解
     * @param s
     * @return
     */
    public static int romanToInt1(String s) {
        if(s == null){
            return 0;
        }
        if(map.get(s) != null){
            return map.get(s);
        }
        String[] strs = s.split("");
        int sum = 0;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals("I") && i+1 < strs.length && (strs[i+1].equals("V") || strs[i+1].equals("X"))){
                sum += (map.get(strs[i+1])-map.get(strs[i]));
                i++;
                continue;
            }
            if(strs[i].equals("X") && i+1 < strs.length && (strs[i+1].equals("L")|| strs[i+1].equals("C"))){
                sum += (map.get(strs[i+1])-map.get(strs[i]));
                i++;
                continue;
            }
            if(strs[i].equals("C") && i+1 < strs.length && (strs[i+1].equals("D")|| strs[i+1].equals("M"))){
                sum += (map.get(strs[i+1])-map.get(strs[i]));
                i++;
                continue;
            }
            int number = map.get(strs[i]);
            sum += number;

        }
        return sum;
    }
    static Map<String,Integer> map = new HashMap<>();
    static {
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }


    public static void main(String[] args){
        String[] strings = {"III","IV","IX","XL","XC","CD","CM","LVIII","MCMXCIV"};
        for(String s : strings){
            System.out.println(romanToInt(s));
        }

    }

}
