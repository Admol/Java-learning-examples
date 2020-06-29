package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * @author : admol
 * @Date : 2020/6/28
 */
public class Lc0189{
    /**
     * 使用反转
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        if(k == 0 || len < 2){
            return;
        }
        // 1.反转整个数组
        reverse(nums,0,len-1);
        // 2. 反转前k个数字
        reverse(nums,0,k-1);
        // 3. 反正后面n-k个数字
        reverse(nums,k,len-1);
        // 打印输出
        Arrays.stream(nums).forEach(a->System.out.print(a + " "));
        System.out.println();
    }

    /**
     * 反转指定区间的数组
     * @param nums
     * @param l
     * @param r
     */
    private static void reverse(int[] nums,int l,int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    /**
     * 循环替换
     * 输入: [1,2,3,4,5,6,7] 和 k
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 输出步骤:
     *  1,2,3,1,5,6,7  temp = 4;
     *  1,2,3,1,5,6,4  temp = 7;
     *  1,2,7,1,5,6,4  temp = 3;
     *  1,2,7,1,5,3,4  temp = 6;
     *  1,6,7,1,5,3,4  temp = 2;
     *  1,6,7,1,2,3,4  temp = 5;
     *  5,6,7,1,2,3,4  temp = 1;
     *
     * 输入: 1,2,3,4 k=2
     * 输出: 3,4,1,2
     * 1,2,1,4  temp = 3
     * 3,2,1,4  temp = 1
     * 3,2,1,4  temp = 1
     * 1,2,1,4  temp = 3
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        System.out.print("原数组:");
        Arrays.stream(nums).forEach(a->System.out.print(a + " "));
        System.out.print("  k:"+k);
        System.out.println();

        int len  = nums.length;
        k = k % len;
        if(k == 0 || len < 2){
            return;
        }
        // 控制交换次数
        int count = 0;
        int i = 0;
        // 记录下开始的位置
        int start = i;
        int temp = nums[i];
        while(count < len){
            // 1.确定需要替换的位置 (i + k) % nums.length
            i = (i + k) % len;
            // 2.交换两个数
            int back = nums[i];
            nums[i] = temp;
            temp = back;
            // 3.确定下一个数的位置
            if(start == i){
                // 判断是否回到了开始的位置
                start++;
                i = start;
                temp = nums[i];
            }
            count ++;
            Arrays.stream(nums).forEach(a->System.out.print(a + " "));
            System.out.print("  temp:"+temp);
            System.out.println();
        }
        System.out.println("最终结果:");
        Arrays.stream(nums).forEach(a->System.out.print(a + " "));
        System.out.println();
    }
    /**
     * 用了多余的辅助空间
     * 输入: [1,2,3,4,5,6,7,8,9,10,11,12] 和 k = 3
     * 输出: [10,11,12,1,2,3,4,5,6,7,8,9]
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0 ||  nums.length < 2){
            return;
        }
        // 用了多余的存储空间
        int[] temp = Arrays.copyOf(nums,nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[(i+k) % nums.length] = temp[i];
        }
    }

    public static void main(String[] args){
        rotate(new int[]{1,2},1);
        rotate(new int[]{1,2,3},3);
        rotate(new int[]{1,2,3,4},2);
        rotate(new int[]{1,2,3,4,5,6,7},1);
        rotate(new int[]{1,2,3,4,5,6,7},3);
        rotate(new int[]{1,2,3,4,5,6,7,8},3);
    }
}
