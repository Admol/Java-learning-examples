package net.admol.jingling.demo.other;

import java.util.HashMap;

/**
 * @author : admol
 * @Date : 2019/10/25
 */
public class FindChar{
    /**
     * 找出字符串中出现次数最多的字母，次数相同的情况下返回ascii code更小的，没有字母的话返回null(忽略大小写，统一当成小写处理).
     * @param string
     * @return
     */

    public static Character mostFrequentLetter(String string) {
        if(string == null){
            return null;
        }
        // 转小写
        char[]  array = string.toLowerCase().toCharArray();
        if(array.length < 1){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>(array.length);
        Character result = null;
        // 记录有重复字母时最大的字符
        Character maxChar = null;
        // 记录没有重复字母时最小的字母
        Character minChar = null;
        for(Character c : array){
            if(!Character.isLetter(c)){
                continue;
            }
            Integer value = map.get(c);
            if(value == null){
                map.put(c,1);
                if(minChar == null || c.compareTo(minChar) < 0){
                    minChar = c;
                }
            }else{
                // 有重复字母, 次数+1
                map.put(c,value + 1);
                if(maxChar == null || c.compareTo(maxChar) < 0){
                    maxChar = c;
                }
                //
            }

        }
        result = maxChar == null ? minChar : maxChar;
        return result;
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
        System.out.println(mostFrequentLetter("1234_."));
        System.out.println(mostFrequentLetter("avccvvva."));
        System.out.println(mostFrequentLetter("asdv."));
        int a[]={0,1,5,6,7,9,14};
        int b[]={2,4,8,10,13};
        int array[]=new int[a.length+b.length];
        int all[]= mergeArray(a, 0, b, 0, array, 0);
        byte[] v = "abc".getBytes();
        System.out.println(v[1]);
        String s = "123";
        String s2 = "123";
        System.out.println(s2 == s);
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
