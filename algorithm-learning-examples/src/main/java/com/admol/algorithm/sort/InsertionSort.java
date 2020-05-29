package com.admol.algorithm.sort;

/**
 * 插入排序
 * 最好的情况 有序的:O(n)
 * 最坏的情况 倒序的:O(n*n)
 * @author : jingling
 * @Date : 2018/10/29
 */
public class InsertionSort{

    public static void insetSort(int[] array){
        int length = array.length;
        if(length <= 1){
            return;
        }
        //i = 1 , 从第二个数字开始遍历循环, 从左到右, 已排序区, 未排序区,到全部排序,将未排序中的一个数插入到已排序区中
        for(int i=1;i<length;i++){
            int a = array[i];
            int j = i - 1;
            // 倒序判断,并移动数组
            for(;j >= 0;j--){
                if(array[j] > a){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] =a;
        }
    }

    public static void main(String[] args){
        int[] a = {2,1,4,5,3,7,8};
        insetSort(a);
        System.out.println(a);
    }
}
