package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 *
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 *
 * 提示:
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 *
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * @author : admol
 * @Date : 2020/7/23
 */
public class Lc0747{


    /**
     * 找到最大值及其索引, 找到次最大值, 比较其倍数关系
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                // 找到最大值和索引
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }else if(nums[i] > secondMax){
                // 更新第二大值
                secondMax = nums[i];
            }
        }
        return max>=2*secondMax?maxIndex:-1;
    }

    public static void main(String[] args){
        System.out.println(dominantIndex(new int[]{1}));
        System.out.println(dominantIndex(new int[]{0,0,3,2}));
        System.out.println(dominantIndex(new int[]{1,1,2,3,7}));
        System.out.println(dominantIndex(new int[]{1,1,2,4,7}));
    }
}
