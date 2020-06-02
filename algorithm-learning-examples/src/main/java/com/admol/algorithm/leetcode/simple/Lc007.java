package com.admol.algorithm.leetcode.simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 示例 1:
 * 输入: 123 输出: 321
 * 示例 2:
 * 输入: -123 输出: -321
 * 示例 3:
 * 输入: 120  输出: 21
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author : admol
 * @Date : 2020/6/2
 */
public class Lc007{

    /**
     * 通过数学计算求余的方式来求解
     * 详细步骤如:
     * 123 % 10 = 12 余 3 , 得到12 和  3
     * 12 % 10 = 1 余  2,   得到 1 和  2
     * 1 % 10 = 0 余 1 ,    得到 0 和  1
     * 这里有两个变量 每次求余的结果值 r 和余值 y
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        int yu = 0;
        while(x != 0){
            // 每次的余数
            yu = x % 10;
            // 判断是否可能会溢出
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && yu > 7)){
                // 后面会乘以10, 所以这里先➗10
                // Integer的 MAX_VALUE 是 2147483647, 假如我们最后result * 10 是214748364, 那余数就不能大于7, 否则会溢出
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && yu < -8)){
                // 后面会乘以10, 所以这里先➗10
                // Integer的 MIN_VALUE 是 -2147483648, 假如我们最后result * 10 是214748364, 那余数就不能小于-8, 否则会溢出
                return 0;
            }
            // 计算结果, 只需要用到每次的余数
            result = result * 10 + yu;
            // 整除10的值
            x = x / 10;
        }
        return result;
    }

    /**
     *  字符串方式
     *  溢出通过try catch解决
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        boolean flag =  x < 0;
        String s = String.valueOf(x);
        if(flag){
            s = s.replaceFirst("-","");
        }
        StringBuffer sb = new StringBuffer();
        char[] cc =  s.toCharArray();
        for(int i = cc.length -1 ; i >=0 ; i--){
            sb.append(cc[i]);
        }
        try{
            int value = Integer.valueOf(sb.toString());
            value = flag ? value * -1: value;
            return value;
        }catch(NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args){
        System.out.println(reverse(123));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(463847412));
        System.out.println(reverse(1114748369));
        //2147483647
        //1114748369
        System.out.println(Integer.MAX_VALUE );
        System.out.println(Integer.MIN_VALUE );
    }
}
