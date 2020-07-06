package com.admol.algorithm.leetcode.simple;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 示例:
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。 
 *
 *  The isBadVersion API is defined in the parent class VersionControl.
 *       boolean isBadVersion(int version);
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * @author : admol
 * @Date : 2020/7/6
 */
public class Lc0278{

    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        return searchBad(left,right);
    }

    private static int searchBad(int left,int right){
        if(left >= right){
            // 查找临界条件
            return left;
        }
        int mid = (right-left)/2 + left;
        if(isBadVersion(mid)){
            //1.说明mid已经是错误版本了, 第一个肯定在 [left,mid]中
            // 继续二分查找
            return searchBad(left,mid);
        }
        //2.说明mid不是错误版本, 第一个肯定在 [mid+1,right]中
        return searchBad(mid+1,right);
    }

    private static boolean isBadVersion(int i){
        return i >=4;
    }

    public static void main(String[] args){
        System.out.println(firstBadVersion(5));
    }
}
