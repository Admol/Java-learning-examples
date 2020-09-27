package com.admol.algorithm.leetcode.medium.array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * @author : admol
 * @Date : 2020/8/18
 */
public class Lc0016{

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int a = 0; a < n; a++){

            int b = a + 1;
            int c = n - 1;
            while(c > b){
                if(nums[a] + nums[b] + nums[c] == target){
                    return target;
                }

                c--;
            }

        }

        return 0;
    }
}
