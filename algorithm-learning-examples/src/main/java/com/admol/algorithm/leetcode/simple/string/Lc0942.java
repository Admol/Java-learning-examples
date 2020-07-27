package com.admol.algorithm.leetcode.simple.string;

/**
 * 增减字符串匹配
 *
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 *
 * 示例 1：
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * @author : admol
 * @Date : 2020/7/27
 */
public class Lc0942{
    /**
     * 只有A[i] < A[i+1]  或者  A[i] > A[i+1]的关系, 所以每次取最大值或者最小值来表示ID即可, 从[0...N]的两端开始取
     * 如果是D, 则每次取最大的
     * 如果是I,则每次取最小的
     * @param S
     * @return
     */
    public static int[] diStringMatch(String S) {
        int N = S.length();
        int up = 0;
        int down = N;
        int[] ans = new int[N+1];
        for(int i = 0; i < S.length(); i++){
            if('D' == S.charAt(i)){
                ans[i] = down--;
            }else {
                ans[i] = up++;
            }
        }
        ans[N] = up;
        return ans;
    }

    public static void main(String[] args){
        // 0 1 2 3 4 5
        // 1 0 3 2 5 4
        System.out.println(diStringMatch("DIDID"));
        //5 4 3 0 1 2     5 4 2 0 1 3  5 4 1 0 2 3
        System.out.println(diStringMatch("DDDII"));
    }
}
