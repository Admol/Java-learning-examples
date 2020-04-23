package net.admol.jingling.demo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author : admol
 * @Date : 2018/3/19
 */
public class Test1 {

    /**
     * 生成指定长度的数组
     * @param lenth
     * @return
     */
    public static int[] buidArrays(int lenth){
        int[] arrays =new int[lenth];
        for (int i = 0; i < lenth ;i++){
            arrays[i] = (int)(Math.random()*lenth) * (Math.random() >0.5?1:-1) ;
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] arrays = buidArrays(100);
//        System.out.println(JSON.toJSONString(arrays));
        Long start = System.currentTimeMillis();
        List<TestNumber> numberList = new ArrayList<>();
        for (int a = 0 ;a < arrays.length ; a++){
            for (int b = a + 1 ; b < arrays.length ; b++){
                TestNumber number = new TestNumber();
                number.one = arrays[a];
                number.two = arrays[b];
                number.last_index = b;
                numberList.add(number);
            }
        }
//        System.out.println(JSON.toJSONString(numberList));
        Set<TargetNumber> targetList = new HashSet<>();
        for (TestNumber number : numberList){
            if(number.last_index < arrays.length - 1){
                for (int a = number.last_index + 1 ;a < arrays.length ; a++){
                    if(arrays[a] + number.one + number.two == 0){
                        TargetNumber targetNumber = new TargetNumber();
                        targetNumber.one = number.one;
                        targetNumber.two = number.two;
                        targetNumber.three = arrays[a];
                        targetList.add(targetNumber);
                    }
                }
            }
        }
        System.out.println("耗时:"+(System.currentTimeMillis() -start));
        System.out.println(JSON.toJSONString(targetList));

        Long start2 = System.currentTimeMillis();
        List<List<Integer>>  list = threeSum(arrays);
        System.out.println("耗时:"+(System.currentTimeMillis() -start2));
        System.out.println(JSON.toJSONString(list));
    }


    static class TestNumber{
        public Integer one;
        public Integer two;
        public Integer last_index;
    }

    static class TargetNumber{
        public Integer one;
        public Integer two;
        public Integer three;

        @Override
        public int hashCode() {
            return String.valueOf(one).hashCode()+String.valueOf(two).hashCode()+String.valueOf(three).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this){
                return true;
            }
            if(obj instanceof TargetNumber){
                TargetNumber number = (TargetNumber)obj;
                String thisStr = String.valueOf(String.valueOf(this.one).hashCode()+String.valueOf(this.two).hashCode()+String.valueOf(this.three).hashCode());
                String objStr = String.valueOf(String.valueOf(number.one).hashCode()+String.valueOf(number.two).hashCode()+String.valueOf(number.three).hashCode());
                return thisStr.equals(objStr);
            }
            return false;
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) {
                return res;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (k > j && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
