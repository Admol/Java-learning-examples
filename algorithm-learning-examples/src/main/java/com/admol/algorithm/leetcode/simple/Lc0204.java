package com.admol.algorithm.leetcode.simple;

import java.util.HashSet;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author : admol
 * @Date : 2020/6/30
 */
public class Lc0204{
    public static int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>(n/2);
        for (int i = 2; i * i < n; i++){
            if(!set.contains(i)){
                for (int j = i * i; j < n; j += i){
                    // 不是质数的统计
                    set.add(j);
                }
            }
        }
        System.out.println("不是质数的总数: "+set.size());
        return n - set.size() - 2;
    }
    /**
     * 埃拉托斯特尼篩法 (Sieve of Eratosthenes)
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {

        // 初始化数组, 默认false,都是质数
        boolean[] isPrim = new boolean[n];
        for (int i = 2; i * i < n; i++){
            if (!isPrim[i]){
                for (int j = i * i; j < n; j += i){
                    isPrim[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++){
            if (!isPrim[i]){
                count++;
            }
        }
        return count;
    }
    /**
     * 质数:除了1和它本身以外不再有其他因数的自然数
     * 1 不算质数
     * @param n
     * @return
     */
    public static int countPrimes1(int n) {
        if(n < 2){
            return 0;
        }
        int count =0;
        for(int i = 2; i < n; i++){
            // 默认是质数
            boolean flag = true;
            for(int j = 2; j < i; j++){
                // 只要有一个能被整除, 说明i不是质数
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("质数:"+i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
//        System.out.println(countPrimes(2));
//        System.out.println(countPrimes(3));
//        System.out.println(countPrimes(10));
//        System.out.println(countPrimes(12));
//        System.out.println(countPrimes(20));
//        System.out.println(countPrimes(10000));
//        System.out.println(countPrimes(499979));
        System.out.println(countPrimes2(1500000));
    }
}
