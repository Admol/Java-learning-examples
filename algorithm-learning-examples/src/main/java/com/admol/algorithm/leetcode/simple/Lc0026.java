package com.admol.algorithm.leetcode.simple;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。

 * @author : adoml
 * @Date : 2020/6/10
 */
public class Lc0026{
    /**
     * 时间复杂度：O(n)，假设数组的长度是 nn，那么 ii 和 jj 分别最多遍历 nn 步。
     * 空间复杂度：O(1)。
     * @param nums  [0,0,0,1,1,1,2,2,3,3,4]
     * @return 返回移除重复出现的元素后数组的新长度  [0,1,2,3,4,1,2,2,3,3,4]
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        // 需要被覆盖更新的位置
        int needUpdateIndex = 1;
        for(int i = 1; i < nums.length; i++){
            // 找一个不重复的数字更新
            if(nums[i] == nums[needUpdateIndex-1]){
                continue;
            }
            // 找到了不重复的数字, 覆盖更新
            nums[needUpdateIndex] = nums[i];
            needUpdateIndex++;
        }
        return needUpdateIndex;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0,0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0,0};
        System.out.println(removeDuplicates(nums));
    }
}
