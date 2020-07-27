package com.admol.algorithm.leetcode.simple.array;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 链接：https://leetcode-cn.com/problems/house-robber
 * @author : admol
 * @Date : 2020/6/29
 */
public class Lc0198{

    /**
     * 动态规划+数组
     * 不能连续访问数组相邻的两个元素
     * 1.如果只有一间房间, 则只能偷该房间才能最大值
     * 2.如果只有两件房间, 则只能偷其中金额高的一间
     * 3.如果房间数大于2(i>2), 有两种情况:
     *    3.1: 如果偷取第i间房间, 就不能偷取第i-1间房间, 偷取的总金额就是前面i-2间房屋的最大金额与第i间房屋的金额之和
     *    3.2: 如果不偷取第i间房间, 偷取的最大金额就是前i-1间房屋的最高金额
     * 用dp[i]表示前 i 间房屋能偷窃到的最高总金额, 则对应的状态转移方程为:
     *      dp[i] = max(dp[i-2]+num[i],dp[i-1])
     * 最终的答案即为 dp[n−1], 其中 n 是数组的长度
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            // 只有一间房间
            return nums[0];
        }
        // 结果数组, 对应第i间时最大值
        int[] dp = new int[length];
        // 偷第1间时只有一个选择
        dp[0] = nums[0];
        // 偷第2间时, 可以偷到的最高金额
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[length-1];
    }

    /**
     * 动态规划+
     * 动态规划的的四个解题步骤是：
     * 1.定义子问题
     * 2.写出子问题的递推关系
     * 3.确定 DP 数组的计算顺序
     * 3.空间优化（可选）
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            // 只有一间房间
            return nums[0];
        }
        // 偷第1间时只有一个选择
        int one = nums[0];
        // 偷第2间时, 可以偷到的最高金额
        int max = Math.max(nums[0],nums[1]);
        for(int i = 2; i < length; i++){
            int temp = max;
            // 如果one+nums[i] > max, 则说明是偷了第i间房间的
            max = Math.max(one+nums[i],max);
            one = temp;
        }
        return max;
    }

    public static void main(String[] args){

    }
}
