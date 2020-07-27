package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * @author : admol
 * @Date : 2020/7/24
 */
public class Lc0905{

    /**
     * 双指针
     * 从前面找奇数
     * 从后面找偶数
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left<right){
            // 1.找到左边的奇数和右边的偶数
            if((A[left] & 1) != 0 && (A[right] & 1) != 1){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                continue;
            }
            // 2.左边是偶数,右移
            if((A[left] & 1) != 1){
                left++;
            }
            // 3.右边是奇数,左移
            if((A[right] & 1) != 0){
                right--;
            }
        }
        return A;
    }

    public static void main(String[] args){
        System.out.println(sortArrayByParity(new int[]{3,1,2,4}));
        System.out.println(sortArrayByParity(new int[]{1,1,2,4}));
    }
}
