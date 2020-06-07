package net.admol.jingling.demo.zuoye;

import java.util.Scanner;

/**
 * @author : admol
 * @Date : 2020/5/24
 */
public class Test03{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num=0,temp;
        do{
            System.out.print("请输入一个4位正整数：");
            num = s.nextInt();
        }while (num<1000||num>9999);

        int a[]=new int[4];
        a[0] = num/1000;
        a[1] = (num/100)%10;
        a[2] = (num/10)%10;
        a[3] = num%10;
        // 加密
        for(int j=0;j<4;j++){
            //每位数字都乘以 2
            a[j]*=2;
            //然后用乘积除以 10 的余数代替该数字
            a[j]%=10;
        }
        for(int j=0;j<=1;j++){
            temp = a[j];
            //将第一位和第三位交换，第二位和第四位交换
            a[j] = a[2+j];
            a[2+j] =temp;
        }
        System.out.print("加密后的数字为：");
        for(int j=0;j<4;j++){
            System.out.print(a[j]);
        }
    }
}
