package com.admol.algorithm.leetcode.simple.math;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 示例 1: 输入: 1   输出: "1"     解释：这是一个基本样例。
 * 示例 2: 输入: 4    输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；
 * 类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * @author : admol
 * @Date : 2020/6/11
 */
public class Lc0038{

    static Map<Integer,String> map = new HashMap(30);

    /**
     * 这道题目看第一遍的时候没看懂, 最后仔细琢磨了一下才明白是什么意思
     * 因为题目说序列中的每一项都是对前一项的描述, 所以必须要知道前面一项是什么了,而开始项为1
     * 后面的都是先描述前面一项, 可以认为读的公式为有 (N个M)
     * 比如:开始项 1 -> 1
     * 后面2,就是描述前面的1, 根据自创公式(N个M)被读作为 1个1, 然后把读作的字符串里面的数字单独出来, 就是11了
     * 后面3,就是描述11, 根据自创公式(N个M)被读作为 2个1, 提取数字, 为21
     * 后面4, 描述21, 根据自创公式(N个M)被读作为 1个2,1个1, 提取数字为1211
     * 后面5, 描述1211, 根据公式读作 1个1,1个2,2个1, 提取数字后为 111221
     * 后面6, 描述111221, 根据公式读作3个1,2个2,1个1,写为: 312211
     * 后面7, 描述312211, 读作: 1个3,1个1,2个2,2个1,写为: 13112221
     * 依次类推.........
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String result = "1" ;
        if(n == 1){

            return result;
        }
        map.put(1,"1");
        for(int i = 2; i <= n ; i++){
            // 1. 取前一项的字符串
            String lastStr = map.get(i-1);
            // 2. 开始读字符串
            result = readStr(lastStr);
            map.put(i,result);
        }
        return  result;
    }

    /**
     * 描述1211, 根据公式读作 1个1,1个2,2个1, 提取数字后为 111221
     * @param lastStr  1211
     * @return  111221
     */
    private static String readStr(String lastStr){
        StringBuilder sb = new StringBuilder();
        char[] strs = lastStr.toCharArray();
        char c = strs[0];
        int count = 0;
        for(int i = 0; i < strs.length ; i++){
            if(strs[i] == c){
                // 重复字符就++
                count ++;
            }else{
                // 遇到不一样的字符, 按照N个N公式进行拼接字符
                sb.append(count).append(c);
                // 重新赋值新的字符进行统计
                c = strs[i];
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }

    public static void main(String[] args){
        IntStream.range(1,31).forEach(i->{
            System.out.println(i+" 输出为: "+countAndSay(i));
        });
    }
}
