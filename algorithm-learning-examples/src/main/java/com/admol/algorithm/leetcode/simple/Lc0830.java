package com.admol.algorithm.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 标签:数组
 *  较大分组的位置
 *  在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 *
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 *
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * @author : admol
 * @Date : 2020/7/23
 */
public class Lc0830{


    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length();
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                if (j-i+1 >= 3){
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }

        return ans;
    }
    /**
     *
     * @param S
     * @return
     */
    public static List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if(S == null || S.length() == 0){
            return res;
        }
        S = "#"+S+"#";
        // 前进指针
        int end = 1;
        // 起点
        int begin = 0;
        // #aabbbbcccc
        while(end<S.length()){
            if(S.charAt(end) == S.charAt(end-1)){
                end++;
            }else{
                // 检查长度, 满足就加入结果
                if(end-begin >= 3){
                    List<Integer> list = new ArrayList();
                    list.add(begin-1);
                    list.add(end-1-1);
                    res.add(list);
                }
                begin = end;
                end++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("aaabbbbaav"));
    }
}
