package net.admol.jingling.demo.algorithm;

/**
 * 选择排序
 * @author : admol
 * @Date : 2018/10/29
 */
public class SelectionSort{

    public static void sort(int[] array){
        int length = array.length;
        if(length <= 1){
            return;
        }
        // 每次从未排序区域选择一个最小的, 放到已排序区域的最后
        for(int i = 0;i<length;i++){
            //找到最小值的下标索引
            int minIndex =i;
            // 从未排序区域找最小值的下标索引
            for(int j = i+1 ;j < length;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //将找到的最小值依次放到已排序区域
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args){
        int[] a = {2,1,4,5,3,6,3,7,8};
        sort(a);
        System.out.println(a);
    }
}
