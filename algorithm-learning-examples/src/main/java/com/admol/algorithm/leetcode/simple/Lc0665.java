package com.admol.algorithm.leetcode.simple;


/**
 * 标签:数组
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 * 说明：
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * @author : admol
 * @Date : 2020/7/20
 */
public class Lc0665{

    public static boolean checkPossibility(int[] nums) {
        if(nums==null||nums.length<=1){
            return true;
        }
        int cnt=0;
        for(int i=1;i<nums.length && cnt<2;i++){
            if(nums[i-1]<=nums[i]){
                continue;
            }
            // 不满足条件计数+1
            cnt++;
            if(i-2>=0 && nums[i-2]>nums[i]){
                nums[i]=nums[i-1];
            }else{

                nums[i-1]=nums[i];
            }
        }
        return cnt <= 1;
    }
    /**
     * 遍历当前数组, 只要找到两个数,比后面的数字要大, 就不可以变成一个非递减数列
     * @param nums
     * @return
     */
    public static boolean checkPossibility1(int[] nums) {
        int count = 0;
        int[] cache = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length ; j++){
                if(nums[i] > nums[j] && cache[j] != 1){
                    cache[j] = 1;
                    count++;
                    break;
                }
            }
            if(count >= 2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(checkPossibility(new int[]{4,2,3}));
        System.out.println(checkPossibility(new int[]{4,2,1}));
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
        System.out.println(checkPossibility(new int[]{3,3,2,2}));
        System.out.println(checkPossibility(new int[]{2,3,3,2,4}));
    }
}
