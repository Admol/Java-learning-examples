package net.admol.jingling.demo.algorithm;

/**
 * @author : admol
 * @Date : 2019/11/6
 */
public class BigArrayTest{

    public static void main(String[] args){
        int[] a = initAray(10000000);
        int key = 9000400;
        long start = System.currentTimeMillis();
        int index = findBigArray(a, key);
        System.out.println("哨兵模式从大数组查询索引: "+index + " 耗时: "+ (System.currentTimeMillis() -start));
        start = System.currentTimeMillis();
        index = find(a, key);
        System.out.println("从大数组查询索引: "+index + " 耗时: "+ (System.currentTimeMillis() -start));
    }




    private static int[] initAray(int size){
        int i=0;
        int[] a = new int[size];
        while(i < size){
            a[i] = (int)(Math.random() * size);
            i++;
        }
        return a;
    }

    /**
     * 普通的循环查找
     * @param a
     * @param key
     * @return
     */
    private static int find(int[] a,int key){
        if(a == null || a.length < 1){
            return -1;
        }
        int i = 0;
        while(i < a.length){
            if(a[i] == key){
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 添加一个哨兵模式, 从比较大的数组中查询索引
     * @param a
     * @param key
     * @return
     */
    private static int findBigArray(int[] a,int key){
        int length = a.length;
        if(a == null || length < 1){
            return -1;
        }

        // 如果数组的最后一个与之相等,则直接返回
        if(a[length - 1] == key){
            return length-1;
        }
        int temp = a[length - 1];
        a[length - 1] = key;

        int i = 0;
        //while 循环比起代码一，少了i < a.length 的判断逻辑
        while(a[i] != key){
            i++;
        }
        a[length - 1] = temp;
        if(length - 1 == i){
            return -1;
        }else{
            return i;
        }
    }
}
