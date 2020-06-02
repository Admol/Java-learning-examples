package com.admol.algorithm.leetcode.simple;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 如: 给定 nums = [2, 7, 11, 15], target = 9 返回 [0, 1]
 * @author : admol
 * @Date : 2020/6/2
 */
public class Lc001{

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length < 2){
            return result;
        }
        // 使用桶记录nums[i]的索引
        HashMap<Integer,Integer> map = new HashMap(nums.length);
        for(int i = 0; i < nums.length; i++){
            // 先从桶里面查询是否有需要值, 没有的话就加入到索引桶里面
            Integer value = map.get(target - nums[i]);
            if(value != null){
                result[0] = value;
                result[1] = i;
                break;
            }
            // 记录索引
            map.put(nums[i],i);
        }
        return result;
    }

}
