package com.admol.algorithm.leetcode.simple.array;

/**
 *
 * 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * @author : admol
 * @Date : 2020/7/27
 */
public class Lc0977{

    /**
     * 双指针
     * 每次比较两端的次方, 取最大的放到结果数组的最后
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        // 左指针
        int left = 0;
        // 右指针
        int right = A.length-1;
        // 赋值指针
        int index = A.length-1;
        while(index >= 0){
            int l = A[left] * A[left];
            int r = A[right] * A[right];
            // 1.取最大的放到结果数组的最后
            if(l < r){
                ans[index] = r;
                // 右指针左移
                right--;
            }else if(l > r){
                ans[index] = l;
                // 左指针右移
                left++;
            }else {
                // 相等的话要赋值两次
                ans[index--] = l;
                if(index >= 0){
                    // ans[0]边界处理
                    ans[index] = l;
                }
                // 左右次方相等, 左右指针都要移动
                left++;
                right--;
            }
            //
            index--;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(sortedSquares(new int[]{-4,-1,0,3,10}));
        System.out.println(sortedSquares(new int[]{-7,-3,2,3,11}));
        System.out.println(sortedSquares(new int[]{-10,-5,2,5,8,10}));
    }
}
