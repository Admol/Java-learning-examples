package net.admol.jingling.demo.jvm;

/**
 * @author : admol
 * @Date : 2020/9/27
 */
public class ConstClass{
    static {
        System.out.println("const class init!");
    }
    public static final String HELLO_WORLD = "Hello,World!";
}
