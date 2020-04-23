package net.admol.jingling.demo.algorithm;

/**
 * 欧几里德算法
 * 欧几里德算法又称辗转相除法，是指用于计算两个正整数a，b的最大公约数
 * @author : admol
 * @Date : 2018/5/13
 */
public class TestOJLD {

    public static void main(String[] args) {

        System.out.println(gcd(1995,5));
    }

    public static int gcd(int a,int b){
        System.out.println("a:"+a+"   b:"+b);
        if(b == 0 ){
            return a;
        }
        int r = a % b;
        if(r == 0){
            return b;
        }
        return gcd(a,r);
    }


}
