package com.admol.algorithm.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1: 输入: [3,2,3]            输出: 3
 * 示例 2: 输入: [2,2,1,1,1,2,2]    输出: 2
 * 链接：https://leetcode-cn.com/problems/majority-element
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0169{
    /**
     * 方法4:
     * 分治的思想
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }
    private static int countInRange(int[] nums,int num,int lo,int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    /**
     * 方法3:统计计数
     * 把众数记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        // 结果
        int res = 0;
        // 统计次数, 出现少的数
        int count =0;
        for(int num : nums){
            if(count ==0){
                // 减到0的时候重置结果
                res = num;
            }
            // 遇到相同的数+1, 不相等的-1;
            count += (num == res) ? 1 : -1;
        }
        return res;
    }
    /**
     * 方法2:
     * 通过排序确认
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        // 排序之后, 出现次数超过n/2的多数元素一定在中间
        return nums[nums.length/2];
    }
    /**
     * 方法1:
     * 利用hash表存储每个数字出现的字数
     * 找出出现次数超过n/2的多数元素
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : count+1;
            if(count > (nums.length / 2)){
                return nums[i];
            }else{
                map.put(nums[i],count);
            }
        }
        return 0;
    }


    public static void main(String[] args){
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
