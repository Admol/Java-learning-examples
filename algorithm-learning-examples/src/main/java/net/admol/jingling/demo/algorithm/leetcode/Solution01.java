package net.admol.jingling.demo.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 * @author : jingling
 * @Date : 2018/8/30
 */
@Slf4j
public class Solution01{

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        if(nums == null || length < 2){
            return result;
        }
        int oneNum = 0;
        int secendNum = 0;
        for(int i = 0 ; i < length ; i++){
            oneNum = nums[i];
            for(int j = i + 1 ; j < length;j ++){
                secendNum = nums[j];
                if(oneNum + secendNum == target){
                    log.info("{} = {} + {}",target,oneNum,secendNum);
                    log.info("对应位置one:{},two:{}",i,j);
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int [] res = new int[2];
        if(numbers==null||numbers.length<2)
            return res;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{
                res[0]= map.get(target-numbers[i]);
                res[1]= i;
                break;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] testArray = {-3,4,3,90};
        int[] result = twoSum2(testArray,0);
        for(int i:result){
            System.out.println("i:"+i);
            log.info("i:{}",i);
        }
    }
}
