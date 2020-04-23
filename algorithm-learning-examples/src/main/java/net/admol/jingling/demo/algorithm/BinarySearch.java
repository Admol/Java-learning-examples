package net.admol.jingling.demo.algorithm;

/**
 * 二分查找
 * 从一个有序数组中查找一个特定的值
 * @author : admol
 * @Date : 2018/11/25
 */
public class BinarySearch{


    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(bSearch(a,18));
        System.out.println(bSearch(a,8));
        System.out.println("=============");
        int[] b = {1,2,3,4,5,6,7,8,8,8,8,9,10};
        System.out.println(bSearch(b,8));
        System.out.println(bSearchFindFirst(b,8));
        System.out.println(bSearchFindFirst(b,18));
        System.out.println("=============");
        System.out.println(bSearchFindLast(b,8));
        System.out.println(bSearchFindLast(b,18));
        System.out.println("=============");

        int[] c = {1,2,3,4,5,6,8,8,8,8,9,10};
        System.out.println(bSearchFindFirstGreaterThanOrEqual(c,7));
        System.out.println("=============");
        System.out.println(bSearchFindLastLessThanOrEqual(c,7));
    }

    /**
     * 利用二分查找从一个有序的数组中查找特定值的索引
     * @param array 默认数组从小到大有序
     * @param value 需要查找的值
     * @return 返回特定值在数组中的索引,不存在则返回-1
     */
    public static int bSearch(int[] array,int value){
        int end = array.length -1;
        int begin = 0;
        while(begin <= end){
            //数组非常非常长的时候,写(begin+end)/2,可能会超过int 最大值
            int mid = begin + (end - begin)/2;
            if(array[mid] > value){
                //特定值可能存在中间值的左边
                end = mid - 1;
            }else if(array[mid] < value){
                //特定值可能存在中间值的右边
                begin = mid + 1;
            }else{
                return mid;
            }

        }
        return -1;
    }

    /**
     * 从有序重复的数组中查找第一个等于指定值的索引
     * @param array 默认重复有序的数组
     * @param value 要查找的指定值
     * @return 返回第一个等于指定值的索引,不存在返回-1
     */
    public static int bSearchFindFirst(int[] array,int value){
        int begin = 0;
        int end = array.length -1;
        while(begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] > value){
                //特定值可能存在中间值的左边
                end = mid - 1;
            }else if(array[mid] < value){
                //特定值可能存在中间值的右边
                begin = mid + 1;
            }else{
                //如果中间值已经是数组的第一个值或者中间值前面的一个数不等于指定的值,说明array[mid]已经是(重复的)指定值中的第一个了
                if(mid == 0 || (array[mid-1] != value)){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 从有序重复的数组中查找最后一个等于指定值的索引
     * @param array 默认重复有序的数组
     * @param value 要查找的指定值
     * @return 返回最后一个等于指定值的索引,不存在返回-1
     */
    public static int bSearchFindLast(int[] array,int value){
        int begin = 0;
        int end = array.length -1;
        while(begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] > value){
                //特定值可能存在中间值的左边
                end = mid - 1;
            }else if(array[mid] < value){
                //特定值可能存在中间值的右边
                begin = mid + 1;
            }else{
                //如果中间值已经是数组的最后一个值或者中间值后面的一个数不等于指定的值,说明array[mid]已经是(重复的)指定值中的第一个了
                if(mid == array.length -1 || (array[mid+1] != value)){
                    return mid;
                }else{
                    begin = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 从有序重复的数组中查找第一个大于或等于指定值的索引
     * @param array 默认重复有序的数组
     * @param value 要查找的指定值
     * @return 返回第一个大于或等于指定值的索引,不存在返回-1
     */
    public static int bSearchFindFirstGreaterThanOrEqual(int[] array,int value){
        int begin = 0;
        int end = array.length -1;
        while(begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] >= value){
                if(mid == 0){
                    return 0;
                }
                if(array[mid - 1] < value){
                    return mid;
                }else{
                    end = mid -1;
                }
            }else{
                //特定值可能存在中间值的右边
                begin = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 从有序重复的数组中查找最后一个小于或等于指定值的索引
     * @param array
     * @param value
     * @return
     */
    public static int bSearchFindLastLessThanOrEqual(int[] array,int value){
        int begin = 0;
        int end = array.length -1;
        while(begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(array[mid] <= value){
                if(mid == array.length -1){
                    return mid;
                }
                if(array[mid+1] > value){
                    return mid;
                }
                begin =  mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
