package com.admol.algorithm.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/3sum
 * @author : admol
 * @Date : 2020/8/14
 */
public class Lc0015{


    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    /**
     * [-1, 0, 1, 2, -1, -4]
     * sort:
     * [-4, -1, -1, 0, 1, 2]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        if(nums.length < 1){
            return ansList;
        }
        // 1.先升序排序
        Arrays.sort(nums);
        int len = nums.length-1;
        int j = 0,k = 0 ,l = 0;

        for(; j < len-1; j++){
            if(nums[j] > 0){
                // 遍历到正数, 不会有更多的答案
                return ansList;
            }
            // 不遍历重复的元素
            if(j > 0 && nums[j-1] == nums[j]){
                continue;
            }
            // 最左边的最小值取反
            int sum = -nums[j];
            l = len;
            if(nums[l]+nums[l-1] < sum){
                // 当前nums[j]不会有答案
                continue;
            }
            k = j + 1;
            while(k < l){

                if(sum == nums[k] + nums[l]){
                    ansList.add(Arrays.asList(nums[j],nums[k],nums[l]));
                    k++;
                    l--;
                    while( k< l && l < len &&  nums[l] == nums[l+1] && k > 0 && nums[k] == nums[k-1]){
                        l--;
                        k++;
                    }
                }else if(sum < nums[k] + nums[l]){
                    l--;
                    while(l < len &&  nums[l] == nums[l+1]){
                        l--;
                    }
                }else {
                    k++;
                    while(k > 0 && nums[k] == nums[k-1]){
                        k++;
                    }
                }
            }

        }
        return ansList;
    }

    public static void main(String[] args){
        System.out.println(new Lc0015().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        System.out.println(new Lc0015().threeSum(new int[]{-2,0,0,2,2}));
        System.out.println(new Lc0015().threeSum(new int[]{1,-1,-1,0}));
        System.out.println(new Lc0015().threeSum(new int[]{0,0,0,0}));
        System.out.println(new Lc0015().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
