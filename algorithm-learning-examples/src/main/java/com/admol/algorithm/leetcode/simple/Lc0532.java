package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 标签:数组
 * 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * 示例 1:
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 * @author : admol
 * @Date : 2020/7/13
 */
public class Lc0532{

    /**
     * [1, 2, 3, 4, 5], k = 1  输出4
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        if(nums.length < 1 || k < 0){
            // 长度小于1 或者 k小于0
            return 0;
        }
        // 1.排序
        Arrays.sort(nums);
        int count = 0;
        // j:遍历指针,从i+1到n-1
        int j = 0;
        // i: 遍历指针, 索引从0到n-1-1
        for(int i = 0; i < nums.length-1; i++){
            if(i >= 1 && nums[i] == nums[i -1]){
                // 排序过后出现重复的数, 直接跳过
                continue;
            }
            j = i+1;
            while(j< nums.length){
                if(nums[i] + k == nums[j]){
                    // 找到匹配, 计数+1;
                    count++;
                    break;
                }
                if(nums[i] + k < nums[j]){
                    // nums[i] + k 不存在匹配结果, 直接跳过
                    break;
                }
                // j指针后移
                j++;
            }
        }
        return count;
    }
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs1(int[] nums, int k) {
        if(nums.length < 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            j = i+1;
            while(j < nums.length){
                // 存绝对值为k的两数之和
                if(Math.abs(nums[i]-nums[j]) == k){
                    set.add(nums[j] + nums[i]);
                }
                j++;
            }
        }
        return set.size();
    }

    public static void main(String[] args){
        System.out.println(findPairs(new int[]{1,1,1,2,1},1));
        System.out.println(findPairs(new int[]{3,1,4,1,5},2));
        System.out.println(findPairs(new int[]{3,1,1,4,5,7},2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5},1));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4},0));
        // 6 4  6 8   3 5   5 7    2 4
        System.out.println(findPairs(new int[]{6,3,5,7,2,3,3,8,2,4},2));
    }
}