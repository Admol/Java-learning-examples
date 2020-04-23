package net.admol.jingling.demo.algorithm;

/**
 * 归并排序
 * 先将数组分成前后两个部分,进行分别排序,然后将排序后的两部分进行合并
 * @author : admol
 * @Date : 2018/11/1
 */
public class MergeSort{

    public static void main(String[] args){
        int[] a = {2,1,4,5,3,6,3,7,8};
        mergeSort(a);
        System.out.println(a);
    }
    public static void mergeSort(int[] array){
        int length  = array.length;
        if(length <= 1){
            return;
        }
        sortInternally(array,0,length-1);
    }

    private static void sortInternally(int [] array,int begin,int end){
        if(begin >= end){
            return ;
        }
        int mid = (end - begin) / 2 + begin;
        //分治递归
        sortInternally(array,begin,mid);
        sortInternally(array,mid+1,end);
        // 合并数组
        mergeArray(array,begin,mid,end);
    }

    private static void mergeArray(int[] array,int begin,int mid,int end){
        //申请临时数组
        int[] temp = new int[end - begin +1];
        //指定两个游标
        int i = begin;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end){
            //依次比较两部分数组, 并依次将小的放入到临时数组中去
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //判断哪个数组还有剩余数据,默认前部分
        int start = i;
        int last = mid;
        if(j <= end){
            //后部分游标,没有到最后
            start = j;
            last = end;
        }
        //将剩余部分复制到临时数组
        while(start <= last){
            temp[k] = array[start];
            k++;
            start++;
        }
        for(i = 0; i< end - begin + 1;i++){
            array[begin + i] = temp[i];
        }
        temp = null;
    }
}
