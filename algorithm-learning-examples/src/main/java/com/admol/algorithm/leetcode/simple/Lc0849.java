package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 *
 * 示例 1：
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 *
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 *  
 *
 * 提示：
 * 2 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 *
 * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
 * @author : jingling
 * @Date : 2020/7/23
 */
public class Lc0849{

    /**
     *
     * 快慢指针
     * [1,0,0,0,1,0,1]
     * slow:1  fast:4 ==> (4-1-1)+1 =3 , 0的个数, (3-1)/2 +1 =2
     * [1,0,0,0,0,1,1]
     * slow:1  fast:5 ==> (5-1-1)+1 =4 , 0的个数, (4-1)/2 +1 =2
     * [1,0,0,0,0,0,1]
     * slow:1  fast:6 ==> (6-1-1)+1 =5 , 0的个数, (5-1)/2 +1 =3
     * [1,0,0,0,0,0,0]
     * slow:1  fast:7 ==> 6
     * [0,0,0,0,0,0,1]
     * slow:0  fast:6 ==> 6
     * @param seats
     * @return
     */
    public static int maxDistToClosest(int[] seats) {

        int fast = 0;
        int slow = 0;
        int res = 0;

        while(slow < seats.length){
            if(seats[slow] == 1){
                slow++;
            }else {
                fast = slow+1;
                while(fast<seats.length && seats[fast] == 0){
                    if(fast == seats.length-1){
                        res = Math.max(res,fast-slow+1);
                    }
                    fast++;

                }
                if(slow == 0){
                    // 最左边没有人, 最长距离就是 fast
                    res = Math.max(res,fast-slow);
                }
                res = Math.max(res,(fast-slow-1)/2+1);
                slow = fast+1;

            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,0,1,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,0,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,0,0,0}));
        System.out.println(maxDistToClosest(new int[]{0,0,0,0,0,0,1}));
        System.out.println(maxDistToClosest(new int[]{0,1,0,0,0,0}));
    }
}
