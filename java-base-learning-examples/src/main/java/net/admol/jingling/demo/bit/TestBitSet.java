package net.admol.jingling.demo.bit;

import java.util.BitSet;

/**
 * @author : jingling
 * @Date : 2021/4/28
 */
public class TestBitSet{
    public static void main(String[] args){
        // 构造方法
//        BitSet bitSet = new BitSet();
//        BitSet bitSet2 = new BitSet(10);

        int sshift = 0;
        int ssize = 1;
        while (ssize < 16) {
            ++sshift;
            ssize <<= 1;
        }
        System.out.println(sshift);
        System.out.println(ssize);
    }
}
