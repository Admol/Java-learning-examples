package com.admol.algorithm.leetcode.simple;

/**
 * 标签:数组
 * 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * @author : admol
 * @Date : 2020/7/17
 */
public class Lc0605{


    /**
     * 什么条件下可以植花?
     * 1.当前位置是零且前后都是0时才可以
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 1){
            // 1.只有一块区域时
            return flowerbed[0] == 0 ? n <=1 : n == 0;
        }
        int count = 0;
        int i = 0;
        while(i<flowerbed.length){
            // 分三种情况
            if(i == 0){
                // 1.判断第一块时, 不需要判断i-1
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    count++;
                    // i+1 已经判断了是0了, 下次不需要再判断了, 直接跳过
                    i+=2;
                    continue;
                }
            }else if(i == flowerbed.length - 1){
                // 2.判断最后一块时, 不需要判断i+1
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    count++;
                    i+=2;
                    continue;
                }
            }else if(flowerbed[i] == 0 && flowerbed[i-1] ==0 && flowerbed[i+1] ==0){
                // 3.其他情况都是判断相邻的三块
                flowerbed[i] = 1;
                count++;
                i+=2;
                continue;
            }
            if(count >= n){
                return true;
            }
            i++;
        }
        return count >= n;
    }

    public static void main(String[] args){
        System.out.println(canPlaceFlowers(new int[]{1},0));
        System.out.println(canPlaceFlowers(new int[]{0},1));
        System.out.println(canPlaceFlowers(new int[]{0},0));
        System.out.println(canPlaceFlowers(new int[]{0,1,0},1));
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},1));
        System.out.println(canPlaceFlowers(new int[]{0,0,0,0,1},1));
    }
}
