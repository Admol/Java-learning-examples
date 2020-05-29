package com.admol.algorithm.sort;

/**
 * 冒泡排序
 * 最好的情况 有序的:O(n)
 * 最坏的情况 倒序的:O(n*n)
 * @author : jingling
 * @Date : 2018/10/16
 */
public class GuluguluSort{
    /**
     * @param array
     */
    public static void guluguluSort(int[] array){
        int length = array.length;
        if(length <= 1){
            return;
        }
        for(int i=0;i<length;i++){
            //校验是否要提前退出循环
            boolean flag = false;
            for(int j = 0;j < length-i-1;j++){
                //比较两个数,是否要交换位置,如果没有要交换的
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag =true;
                }
            }
            if(!flag){
                //没有数据需要交换,已经有序,提前退出
                break;
            }
        }
    }

    public static void bubbleSort(int[] array){
        // 如果前面一个数字比后面数字大,就交换他们的位置
        int size = array.length;
        for (int i=0;i<size ;i++ ) {
            for (int j=0;j<size-1-i ;j++ ) {
                int temp = array[j];
                int after = array[j+1];
                if(temp > after){
                    //交换数据, 如果没有交换,说明已经是有序的,可以直接跳出最外层循环
                    array[j+1] = array[j];
                    array[j] = after;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] a = {2,1,4,5,3,7,8};
//        guluguluSort(a);
//        System.out.println(a);
        bubbleSort(a);
        System.out.println(a);
    }
}
