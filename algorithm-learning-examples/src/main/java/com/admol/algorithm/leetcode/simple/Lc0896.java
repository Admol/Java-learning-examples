package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 *
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 *
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * @author : admol
 * @Date : 2020/7/24
 */
public class Lc0896{


    /**
     * 记录递增递减关系 , 用1表示递增,-1表示递减,0表示平级
     * @param A
     * @return
     */
    public static boolean isMonotonic1(int[] A) {
        if(A.length < 3){
            return true;
        }
        // 1.先确定单调关系
        int cp = Integer.compare(A[1],A[0]);
        for(int i = 2; i < A.length; i++){
            // 2.判断新的关系
            int newCp = Integer.compare(A[i],A[i-1]);
            if(newCp ==0){
                continue;
            }
            if(cp != 0 && newCp != cp){
                return false;
            }
            cp = newCp;
        }
        return true;
    }
    /**
     *
     * 找三个不相同的数, 比较它们的两两之差的乘积, 如果有波动, 肯定是负数
     * 比如:  1 5 4  ==> 4 * -1 , 小于0
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {
        if(A.length < 3){
            return true;
        }
        int two = 1;
        int three = 2;
        while(three < A.length){
            if(A[three] == A[two]){
                three++;
                continue;
            }
            two = three-1;
            int diff1 = A[two] - A[0];
            int diff2 = A[three] - A[two];
            if(diff1 * diff2 < 0){
                return false;
            }
            two++;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isMonotonic(new int[]{1,2,3,4,5}));
        System.out.println(isMonotonic(new int[]{5,4,3,2,1}));
        System.out.println(isMonotonic(new int[]{1,1,1,1}));
        System.out.println(isMonotonic(new int[]{1,2,3,5,4,0}));
        System.out.println(isMonotonic(new int[]{2,2,2,1,4,5}));
        System.out.println(isMonotonic(new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
        System.out.println(isMonotonic(new int[]{1,2,2,2,3,3,3,3,5,5,5,5,2,2,2,1,1,1}));
    }
}
