package com.admol.algorithm.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * @author : admol
 * @Date : 2020/6/16
 */
public class Lc0088{

    /**
     * 开辟一个nums1实际元素大小的副本, 然后依次从副本和nums2中选择一个小的, 依次放入到nums1中
     * 需要多余的存储空间开辟一个nums1实际元素大小的副本
     * 时间复杂度 : O(n+m)。
     * 空间复杂度 : O(m)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1,int m,int[] nums2,int n) {
        // 开辟一个nums1实际元素大小的副本
        int [] nums1_copy = new int[m];
        // 将nums1的实际元素复制到副本
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // nums1副本的指针
        int p1 = 0;
        // nums2的指针
        int p2 = 0;
        // 返回结果nums1的指针
        int p = 0;
        // 从nums1副本和nums2中选择一个小的放到nums1中
        while ((p1 < m) && (p2 < n)){
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        // 将剩余的元素直接copy到nums1的后面
        if (p1 < m){
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n){
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    /**
     * 不需要额外的存储空间开辟副本, 但缺点是每次移动数组数据
     * @param nums1 初始化数组 nums1
     * @param m 已初始化数组nums1的数量
     * @param nums2 初始化数组 nums2
     * @param n 已初始化数组nums2的数量
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length < 1){
            return;
        }
        // 遍历nums1数组的指针
        int j = 0;
        // 遍历nums2数组的指针
        int i = 0;
        while(j < nums1.length && i < n){
            // 1.拿nums2中的元素和nums1中元素比较
            if(nums2[i] < nums1[j]){
                // 2.如果小的话,将nums1数组j及之后的所有y元素后移,然后把nums2中当前元素插入到nums1当前j位置
                System.arraycopy(nums1,j,nums1,j+1,m-j);
                nums1[j] = nums2[i];
                // 3.nums1数组实际元素大小+1
                m++;
                // 4.nums2数组指针前移
                i++;
            }
            if(j >= m){
                // 进入这里,说明nums1数组已经被遍历完了
                // 但是nums2中的元素还没有被合并进来, 也就是nums1最后的数比nums2中间的元素要小, 直接将nums2中的元素插入到nums1后面
                // 比如: nums1 {1,2,3,4,0,0,0,0,0,}, nums2{5,6,7,0,0,0}
                nums1[j] = nums2[i];
                i++;
            }
            j++;
        }
    }

    /**
     * 骚操作1
     * 时间复杂度 : O((n + m)log(n + m))。
     * 空间复杂度 : O(1)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
//        nums1 = new int[]{2,0};
        int m = 3;
        int[] nums2 = {2,5,6};
//        nums2 = new int[]{1};
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(nums1);

    }
}
