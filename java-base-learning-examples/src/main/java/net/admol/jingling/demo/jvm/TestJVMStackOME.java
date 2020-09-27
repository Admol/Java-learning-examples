package net.admol.jingling.demo.jvm;

/**
 * 栈溢出测试
 * JVM args: -Xss128k
 * @author : admol
 * @Date : 2020/9/24
 */
public class TestJVMStackOME{
    private int length = 1;
    public void stackLeak(){
        length++;
        stackLeak();
    }
    public static void main(String[] args){
        TestJVMStackOME test = new TestJVMStackOME();
        try{
            test.stackLeak();
        }catch(Exception e){
            System.out.println("stack length:"+test.length);
            throw e;
        }
    }
}
