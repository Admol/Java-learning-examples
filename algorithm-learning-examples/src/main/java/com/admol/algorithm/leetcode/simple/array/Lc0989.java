package com.admol.algorithm.leetcode.simple.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * @author : admol
 * @Date : 2020/7/27
 */
public class Lc0989{

    public static List<Integer> addToArrayForm(int[] A,int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = A.length-1;

        while(i>=0 || K>0){
            if(i>=0){
                // 数组的末尾直接加到K上面
                K += A[i];
            }
            // 取余数,每次加入到链表的头部
            list.addFirst(K % 10);
            // 去掉K个位数
            K /=10;
            i--;
        }
        return list;
    }
    /**
     * 又臭又长的代码
     * @param A
     * @param K
     * @return
     */
    public static List<Integer> addToArrayForm1(int[] A,int K) {
        LinkedList<Integer> list = new LinkedList<>();

        int i = A.length-1;
        // 进位
        int carry = 0;
        while(i>=0){
            int a = A[i];
            int rem = 0;
            if(K > 0){
                // 取K的个位数
                rem = K % 10;
                K = K / 10;
            }
            int curr = a+rem+carry;
            carry = curr / 10;
            list.addFirst(curr % 10);
            i--;
        }
        while(K>0){
            // 取K的个位数
            int rem = K % 10;
            int curr = rem+carry;
            carry = curr / 10;
            K = K / 10;
            list.addFirst(curr%10);
        }
        if(carry == 1){
            list.addFirst(carry);
        }
        return list;
    }

    public static void main(String[] args){
        addToArrayForm(new int[]{0},23);
        addToArrayForm(new int[]{6},809);
        addToArrayForm(new int[]{1,2,3,4},23);
        addToArrayForm(new int[]{1,2,0,0},34);
        addToArrayForm(new int[]{2,7,4},181);
        addToArrayForm(new int[]{2,1,5},806);
        addToArrayForm(new int[]{9,9,9,9,9},1);
    }
}
