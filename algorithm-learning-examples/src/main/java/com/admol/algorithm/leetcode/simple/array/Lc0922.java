package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * @author : admol
 * @Date : 2020/7/27
 */
public class Lc0922{

    /**
     * [1,2,3,4]
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        // 左指针, 检查该索引位置是否为偶数
        int left = 0;
        // 右指针, 检测该索引位置是否为奇数
        int right = A.length-1;
        while(left<A.length && right>0){

            // 1.如果左边的是奇数  && 右边的是偶数, 交换
            if((A[left] & 1) != 0 && (A[right] & 1) != 1){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                continue;
            }
            // 2.如果左边的是偶数, 前进到下一个理论应该是偶数的位置
            if((A[left] & 1) != 1){
                left+=2;
            }
            // 2.如果右边的是奇数, 前进到下一个理论应该是奇数的位置
            if((A[right] & 1) != 0){
                right-=2;
            }
        }
        return A;
    }

    public static void main(String[] args){
        System.out.println(sortArrayByParityII(new int[]{1,4,4,3,0,3}));
        System.out.println(sortArrayByParityII(new int[]{1,2,3,4}));
        System.out.println(sortArrayByParityII(new int[]{4,2,5,7}));
    }
}
