package com.admol.algorithm.leetcode.medium.string;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * @author : admol
 * @Date : 2020/8/13
 */
public class Lc0044{

    /**
     * 模拟乘法运算
     * 从右往左遍历乘数, 与另一个数相乘, 最后累加得到结果
     *    129
     * *   15
     * ------
     *    645
     *   1290
     * ------
     *   1935
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        } else if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        // 结果数组, 两个数的乘积长度只会是n1+n2或者n1+n2-1
        int[] ans = new int[n1+n2];

        for(int j = n2-1; j >= 0; j--){
            // 从右往左遍历乘数, 转换成数字
            int y = num2.charAt(j)-'0';
            for(int i = n1-1; i >= 0; i--){
                // 从右往左遍历乘数, 转换成数字
                int x = num1.charAt(i)-'0';
                // 依次计算两个数的乘积+数组该位置之前计算的值
                int res = x * y + ans[i+j+1];
                // 更新结果数组
                ans[i+j+1] =  res % 10;
                if(res >= 10){
                    // 数大于等于10, 要考虑进位
                    ans[i+j] += res/10;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        int begin = ans[0] == 0 ? 1 : 0;
        // 把结果数组转换成字符串
        for(int i = begin; i < ans.length; i++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Lc0044().multiply("129","15").equals(129*15+""));
        System.out.println(new Lc0044().multiply("888","15").equals(888*15+""));
        System.out.println(new Lc0044().multiply("123456789","987654321"));
    }
}
