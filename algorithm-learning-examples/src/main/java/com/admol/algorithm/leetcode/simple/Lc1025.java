package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 * 示例 1：
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * 示例 2：
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *  
 *
 * 提示：
 * 1 <= N <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * @author : admol
 * @Date : 2020/7/24
 */
public class Lc1025{

    /**
     * 输入1: 爱丽丝没得选 , 失败
     * 输入2: 爱丽丝先手选择 1, 替换 N 为 2-1, 从小于1选择一个 1 % x ==0 , x不存在, 爱丽丝胜利
     * 输入3: 只有1满足 3 % 1 == 0, 所以爱丽丝必须选择1, 变成2, 爱丽丝失败
     * 输入4: 1,2 都满足N % x == 0; 爱丽丝选择1, 变成3,鲍勃只能选择1,变成2,爱丽丝再选择1, 胜利
     * 输入5: 只有1满足N % x == 0; 爱丽丝只能选择1, 变成4,鲍勃选择1,变成3,爱丽丝再选择1, 鲍勃选择1,失败
     * ...
     * 偶数先手必赢, 奇数先手必输!!!
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return (N & 1) != 1;
    }

    /**
     * 动态规划, 往后递推
     * @param N
     * @return
     */
    public static boolean divisorGame1(int N) {

        // dp[i] 代表先手人的是否能够必赢
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;
        for(int i = 3; i <= N; i++){
            // 爱丽丝先手, 要让对手输掉, 就必须要让满足条件都 N-x 的结果为false, 即dp[N-x]=false, 这样爱丽丝就可以赢得胜利
            for(int x = 1; x < i; x++){
                // 从 1->i 中选择一个dp[x] 为false的, 相当于机会让给对手, 让对手再先手, 那么对手就必输
                if(!dp[i-x] && (i % x)==0){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args){
        System.out.println(divisorGame1(5));
        System.out.println(divisorGame1(6));
        System.out.println(divisorGame1(7));
        System.out.println(divisorGame1(8));
    }
}
