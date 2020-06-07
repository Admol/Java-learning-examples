package net.admol.jingling.demo.zuoye;

import java.util.Scanner;

/**
 * 逆序输出数组
 * @author : admol
 * @Date : 2020/5/24
 */
public class Test01{
    public static void main(String[] args){
        int[] x=new int[10];
        System.out.println("请输入10个数:");
        Scanner s=new Scanner(System.in);
        for(int i=0;i<10;i++){
            x[i]=s.nextInt();
        }
        System.out.println("数组逆序输出:");
        for(int i=x.length-1;i>=0;i--){
            System.out.print(x[i]);
            System.out.print(" ");
        }
    }
}
