package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 * 示例 1：
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 *
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 *  
 *
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * @author : admol
 * @Date : 2020/7/27
 */
public class Lc0941{

    /**
     * 遍历两个段
     * @param A
     * @return
     */
    public static boolean validMountainArray(int[] A) {
        int len = A.length;
        int i = 0;
        while(i < len-1 && A[i]<A[i+1]){
            // 遍历上升段
            i++;
        }
        if(i ==0 || i == len-1){
            // 单调递减或者递增的函数
            return false;
        }
        int j = len -1;
        while(j>=i && A[j] < A[j-1]){
            // 遍历下降段
            j--;
        }
        return i==j;
    }
    /**
     * 上山 下山
     * 必须要先升序 再降序
     * @param A
     * @return
     */
    public static boolean validMountainArray1(int[] A) {
        if(A.length<3){
            return false;
        }
        int up = 0;
        int down = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1] && down == 0){
                // 升序 且 还没有开始下山
                up++;
                continue;
            }else if(A[i] == A[i-1]){
                return false;
            }else if(A[i] < A[i-1] && up>0){
                // 开始下山 且 已经上过山
                down++;
            }
        }
        if(up ==0 || down == 0){
            return false;
        }
        return up + down == A.length-1;
    }

    public static void main(String[] args){
        System.out.println(validMountainArray(new int[]{1,2}));
        System.out.println(validMountainArray(new int[]{3,2}));
        System.out.println(validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
        System.out.println(validMountainArray(new int[]{1,2,3,4,5}));
        System.out.println(validMountainArray(new int[]{1,2,3,4,5,4,3,2,1}));
        System.out.println(validMountainArray(new int[]{1,2,3,4,5,5,4,3,2,1}));
    }
}
