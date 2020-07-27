package com.admol.algorithm.leetcode.simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * @author : admol
 * @Date : 2020/6/22
 */
public class Lc0119{
    /**
     * 利用公式:
     * C(n,k) =C(n,k-1)*(n−k+1)/k
     * n:表示第几行,从0开始
     * k:表示行的第几个元素
     * C(n,k-1): 表示要计算的元素的前一个元素
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            long cur = pre * (rowIndex - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

    /**
     * getRow1的优化
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> resultList = new ArrayList(rowIndex+1);
        resultList.add(1);
        for(int i = 1; i <= rowIndex ; i++){
            for(int j = i -1 ; j > 0; j--){
                // 计算值value = 上一行(j-1) + 上一行(j)
                resultList.set(j,resultList.get(j-1)+resultList.get(j));
            }
            // 每行的最后添加一个1
            resultList.add(1);
        }
        return resultList;
    }

    /**
     * 和118题思路差不多
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> resultList = new ArrayList(rowIndex+1);

        // 记录上一行
        List<Integer> temp = new ArrayList(rowIndex);
        for(int i = 0; i <= rowIndex ; i++){
            List<Integer> rowList = new ArrayList<>(i+1);
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || i == j ){
                    // 1.首位放1
                    rowList.add(1);
                }else{
                    // 计算值value = 上一行(j-1) + 上一行(j)
                    int value = temp.get(j-1)+temp.get(j);
                    rowList.add(value);
                }
            }
            temp = rowList;
            resultList = rowList;
        }
        return resultList;
    }

    public static void main(String[] args){
        System.out.println(getRow(0));
    }
}
