package com.admol.algorithm.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * @author : admol
 * @Date : 2020/6/22
 */
public class Lc0118{
    /**
     * 规律:
     *     j
     * i   1 0 0 0 0
     *     1 1 0 0 0
     *     1 2 1 0 0
     *     1 3 3 1 0
     *     1 4 6 4 1
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList(numRows);
        if(numRows < 1){
            return resultList;
        }
        for(int i = 0; i < numRows ; i++){
            List<Integer> rowList = new ArrayList<>(i+1);
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || i == j ){
                    // 1.首位放1
                    rowList.add(1);
                }else{
                    // 计算值value = 上一行(j-1) + 上一行(j)
                    int value = resultList.get(i-1).get(j-1)+resultList.get(i-1).get(j);
                    rowList.add(value);
                }
            }
            resultList.add(rowList);
        }
        return resultList;
    }

    public static void main(String[] args){
        generate(5);
    }
}
