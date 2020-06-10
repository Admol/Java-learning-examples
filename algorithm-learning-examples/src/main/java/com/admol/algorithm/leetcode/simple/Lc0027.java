package com.admol.algorithm.leetcode.simple;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * @author : admol
 * @Date : 2020/6/10
 */
public class Lc0027{
    /**
     * 时间复杂度：O(n), 要移除的元素很少时效率会更高
     * 空间复杂度：O(1)
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        // 从前往后移动的指针
        int i = 0;
        // 从后面往前移动的指针
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                // 将当前元素与最后一个元素进行交换
                nums[i] = nums[n - 1];
                // 尾巴指针前移
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    /**
     * 不会改变原数组的顺序
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        // 被更新的指针
        int removeIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                // 找到不相等的, 更新到需要被更新的指针
                // 可以理解为, 从数组找到所有不相等的值, 依次更新到数组里面
                nums[removeIndex] = nums[i];
                removeIndex ++;
            }
        }
        return removeIndex;
    }
    /**
     *
     * @param nums  nums = [3,2,2,3]
     * @param val   val = 3
     * @return      函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2
     */
    public static int removeElement1(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1 && nums[0] == val){
            return 0;
        }
        int removeCount = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            // 找到需要被移除的值了
            if(nums[i] == val){
                // 从后面找一个不等于删除值进行交换
                // 有可能全部是需要被移除的值, 所以这里需要先计算
                removeCount++;
                for(index = i+1; index < nums.length; index++ ){
                    if(nums[index] != val){
                        int temp = nums[index];
                        nums[index] = nums[i];
                        nums[i] = temp;
                        // 外面重复计算,所以要减掉
                        removeCount--;
                        break;
                    }
                }
            }
        }
        if(nums.length == removeCount){
            return 0;
        }
        // 返回新的长度
        return nums.length-removeCount;
    }

    public static void main(String[] args){
        int[] nums = {4,2,3,5,4};
//        System.out.println(removeElement(nums,4));
        nums = new int[]{1};
//        System.out.println(removeElement(nums,1));
        nums = new int[]{2};
//        System.out.println(removeElement(nums,3));
        nums = new int[]{3,3};
//        System.out.println(removeElement(nums,3));
        nums = new int[]{3,3};
//        System.out.println(removeElement(nums,5));
        nums = new int[]{3,2,2,3};
        System.out.println(removeElement1(nums,3));
//        nums = new int[]{1,6,2,0,3,1,3,2,2,3};
//        System.out.println(removeElement(nums,3));
    }
}
