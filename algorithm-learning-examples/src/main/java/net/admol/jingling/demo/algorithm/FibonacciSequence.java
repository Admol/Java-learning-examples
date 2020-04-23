package net.admol.jingling.demo.algorithm;

/**
 * 斐波那契数列
 * @author : admol
 * @Date : 2018/5/13
 */
public class FibonacciSequence {

    static Long count  = 0L;
    public static long fs(int n)
    {
        count++;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fs(n-1) + fs(n-2);
    }

    public static void main(String[] args) {
        System.out.println("count: " + fs(2));
        System.out.println("count: " + count);
    }
}
