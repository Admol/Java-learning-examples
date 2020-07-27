package com.admol.algorithm.leetcode.simple.array;

/**
 * 标签:数组
 * 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 *
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 *
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 * @author : admol
 * @Date : 2020/7/21
 */
public class Lc0717{


    /**
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            // 如果bits[i]==1, 那么i增加2
            i += bits[i] + 1;
        }
        // 最终落在了 bits.length−1 的位置，那么说明最后一位一定是一比特字符
        return i == bits.length - 1;
    }

    /**
     * 线性遍历, 找到最后一个比特字符last, 比较最后last是否为0
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter1(int[] bits) {

        int last = 0;
        for(int i = 0; i < bits.length; i++){
            if(bits[i] == 1){
                last = bits[i] * 10 + bits[i+1];
                i++;
            }else {
                last = bits[i];
            }
        }
        return last == 0;
    }

    public static void main(String[] args){
        System.out.println(isOneBitCharacter(new int[]{0}));
        System.out.println(isOneBitCharacter(new int[]{1,0}));
        System.out.println(isOneBitCharacter(new int[]{1,1}));
        System.out.println(isOneBitCharacter(new int[]{1,0,0}));
        System.out.println(isOneBitCharacter(new int[]{1,1,1,0}));
        System.out.println(isOneBitCharacter(new int[]{1,1,0,0}));
        System.out.println(isOneBitCharacter(new int[]{0,1,1,0}));
    }
}
