package net.admol.jingling.demo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @author : admol
 * @Date : 2019/10/25
 */
public class FindChar{
    /**
     * 从一个字符串中找出出现最多的字符, 如果出现的次数相同则选择ascii小的
     * @param string
     * @return
     */
    public static Character mostFrequentLetter(String string) {
        if(string == null){
            return null;
        }
        char[]  array = string.toCharArray();
        if(array.length < 1){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>(array.length);
        int maxCount = 0;
        Character maxChar = null;
        for(Character c : array){
            Integer value = map.get(c);
            // 统计每个char出现的次数
            if(value == null){
                map.put(c,1);
            }else {
                int count = 1 + value;
                map.put(c,count);
                if(count == maxCount){
                    if(!compareChar(maxChar,c)){
                        maxCount = count;
                        maxChar = c;
                    }
                }
                if(count > maxCount){
                    maxCount = count;
                    maxChar = c;
                }
            }
        }
        return maxChar;
    }


    /**
     * 比较ascii code大小
     * @param maxKey
     * @param key
     * @return maxKey < key , 返回true
     */
    private static boolean compareChar(Character maxKey,Character key){
        return maxKey.compareTo(key) < 0;
    }

    public static void main(String[] args){
        System.out.println(mostFrequentLetter("111aaaabcbbbcccc"));
        int a[]={0,1,5,6,7,9,14};
        int b[]={2,4,8,10,13};
        int array[]=new int[a.length+b.length];
        int all[]= mergeArray(a, 0, b, 0, array, 0);
        System.out.println(JSON.toJSONString(all));
        System.out.println(compareChar('a','b'));
    }



    private static int [] mergeArray(int a[],int aStart,int b[],int bStart,int array[],int arrayStart) {


        //若数组a中的元素都已经放到array数组中，而数组b未全部放到array中，
        //那么将b中剩余的元素放到array中
        if (aStart>=a.length) {
            for (int i = arrayStart; i < array.length; i++) {
                array[arrayStart]=b[bStart++];
            }
            return array;
        }
        //若数组b中的元素都已经放到array数组中，而数组a未全部放到array中，
        //那么将a中剩余的元素放到array中
        if (bStart>=b.length) {
            for (int i = arrayStart; i < array.length; i++) {
                array[arrayStart]=a[aStart++];
            }
            return array;
        }
        //将数组的头元素,b数组头元素 中的最小值赋予给array
        if (a[aStart]<b[bStart]) {
            array[arrayStart]=a[aStart];
            return mergeArray(a, aStart+1, b, bStart,  array, arrayStart+1);
        }else {
            array[arrayStart]=b[bStart];
            return mergeArray(a, aStart, b, bStart+1, array, arrayStart+1);
        }

    }
}
