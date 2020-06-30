package com.admol.algorithm.leetcode.simple;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 示例：
 * 输入：19    输出：true
 * 解释：
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 * 链接：https://leetcode-cn.com/problems/happy-number
 * @author : admol
 * @Date : 2020/6/30
 */
public class Lc0202{

    static HashSet<Integer> set = new HashSet<>();

    /**
     * 利用hash表, 将每次计算的结果存储起来, 如果出现重复的说明进入死循环, 直接返回false
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int sum = 0;
        while(n != 0){
            // 余数
            int y = n % 10;
            sum += (y * y);
            n /= 10;
        }
        if(sum == 1){
            return true;
        }
        if(set.contains(sum)){
            return false;
        }
        set.add(sum);
        return isHappy(sum);
    }

    /**
     * 利用快慢指针
     * @param n
     * @return
     */
    public static boolean isHappy2(int n) {
        // 跑得慢的人
        int slow = n;
        // 跑得快的人, 计算两次next, 如果是快乐数, 肯定先到1
        int fast = next(n);
        // 跑得快的人先跑一步,到了1, 就退出奔跑, 返回true
        while(fast != 1){
            // 跑一次
            slow = next(slow);
            // 跑两次
            fast = next(fast);
            fast = next(fast);
            if(slow == fast){
                // 相遇了, 说明有环, 不会快乐的
                return false;
            }
        }
        return true;
    }

    private static int next(int n){
        int sum = 0;
        while(n != 0){
            // 余数
            int y = n % 10;
            sum += (y * y);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
//        System.out.println(isHappy(19));
//        System.out.println(isHappy(4));
//        System.out.println(isHappy(13));
//        System.out.println(isHappy2(19));
//        System.out.println(isHappy2(4));
//        System.out.println(isHappy2(13));
        System.out.println(isHappy2(10));
    }

}
