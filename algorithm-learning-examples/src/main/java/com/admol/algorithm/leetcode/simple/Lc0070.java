package com.admol.algorithm.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：    输入： 2   输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：    输入： 3   输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 参考:https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg
 * @author : admol
 * @Date : 2020/6/15
 */
public class Lc0070{

    /**
     * 动态规划
     * 自底向上的走法, n代表当前台阶, a,b代表上上步台阶和上一步台阶的可能走法数
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int a = 1;
        int b = 2;
        for(int i = 3; i <= n; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    static Map<Integer,Integer> map = new HashMap();
    /**
     * 递归加HashMap方式
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param n 楼梯数
     * @return
     */
    public static int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        Integer value1 = map.get(n-1);
        if(value1 == null){
            value1 = climbStairs1(n-1);
            map.put(n-1,value1);
        }
        Integer value2 = map.get(n-2);
        if(value2 == null){
            value2 = climbStairs1(n-2);
            map.put(n-2,value2);
        }
        return value1+value2;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(4));

    }
}
