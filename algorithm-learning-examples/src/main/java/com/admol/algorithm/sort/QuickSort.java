package com.admol.algorithm.sort;

/**
 * 快速排序, 使用分治思想
 * 如果要排序数组下标是从 p 到 r的一组数据, 那我们选择任一一个数据作为分区点(pivot)
 * 遍历p 到r 之间的数据, 将小于pivot的数据放到左边, 将大于pivot的数据放到右边, 知道区间为1或0
 * @author : admol
 * @Date : 2018/11/2
 */
public class QuickSort{

    public static void main(String[] args){
        int[] a = {2,1,4,9,5,3,7,10,8};
        quickSort(a,a.length);
        System.out.println(111);
    }

    /**
     * 快速排序，
     * @param a
     * @param n 表示数组的大小
     */
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    /**
     * 快速排序递归函数，p,r为下标
     * @param a
     * @param p  起始位置索引
     * @param r  结束位置索引
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r){
            return;
        }
        // 获取分区点,也可以随机取一个
        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        //已处理区域和未处理区域之间的区分游标i
        int i = p;
        for(int j = p; j < r; ++j) {
            //将小于分区点的放到左边
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }
}
