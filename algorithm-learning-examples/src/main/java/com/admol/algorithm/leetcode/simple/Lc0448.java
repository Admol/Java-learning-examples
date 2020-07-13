package com.admol.algorithm.leetcode.simple;

import java.util.*;

/**
 * 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * @author : admol
 * @Date : 2020/7/10
 */
public class Lc0448{
    /**
     * 1.遍历数组元素, 把nums[i]-1 索引位置的元素标记为负数; 因为给定的数组值范围是1 ≤ a[i] ≤ n, nums[i]-1 对应的索引位置就是 0 ≤ a[i] ≤ n-1
     * 2.最后再次遍历数组, 如果不是负数, 说明索引位置i+1不存在之前的数组中
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 把 |nums[i]| -1   索引位置的元素标记为负数
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 使用了额外的存储空间
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        HashSet<Integer> set = new HashSet<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
    /**
     * 排序:
     * nums: [4,3,2,7,8,2,3,1]
     * sort: [1,2,2,3,3,4,7,8]
     * index [1,2,3,4,5,6,7,8]
     *
     * nums: [1,1]
     * sort: [1,1]
     *       [1,2]
     * nums: [2,2]
     * sort: [2,2]
     *       [1,2]
     *
     * nums: [1,1,2,2]
     * sort: [1,1,2,2]
     * index [1,2,3,4]
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        if(len < 1){
            return res;
        }
        Arrays.sort(nums);
        // 自增数
        int index = 1;
        // 遍历数组的指针
        int i = 0;
        //
        while(i < len){
            if(nums[i] != index){
                if(index < nums[i]){
                    while(index < nums[i]){
                        res.add(index);
                        index++;
                    }
                }else{
                    i++;
                    if(i == len && index  == len){
                        // nums[i-1] -> len
                        index = nums[i-1];
                        while(index < len){
                            index++;
                            res.add(index);
                        }
                    }
                }
                if(i == len && index < len){
                    while(index <= len){
                        res.add(index);
                        index++;
                    }
                }
            }else if(nums[i] == index){
                index++;
                i++;
                if(i == len && index  == len && nums[len-1] < len){
                    res.add(len);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(findDisappearedNumbers(new int[]{1}));
        System.out.println(findDisappearedNumbers(new int[]{1,1}));
        System.out.println(findDisappearedNumbers(new int[]{2,2}));
        System.out.println(findDisappearedNumbers(new int[]{3,3,3}));
        System.out.println(findDisappearedNumbers(new int[]{1,1,2,2}));
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[]{3,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[]{27,40,6,21,14,36,10,19,44,10,41,26,39,20,25,19,14,7,29,27,40,38,11,44,4,6,48,39,9,13,7,45,41,23,31,8,24,1,3,5,28,11,49,29,18,4,38,32,24,15}));
    }
}
