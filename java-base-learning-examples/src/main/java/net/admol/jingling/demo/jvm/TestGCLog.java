package net.admol.jingling.demo.jvm;


/**
 * -Xmn10m -Xmx20m -Xms20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * @author : admol
 * @Date : 2020/9/27
 */
public class TestGCLog{

    private static final int _1M = 1024*1024;

    public static void main(String[] args){
//        testMinorGC();
//        testMajorGC();
//        testPretenureSizeThreshold();
        testMaxTenuringThreshold();
    }

    private static void testMajorGC(){
        byte[] ob1,ob2,ob3,ob4;
        ob1 = new byte[_1M * 8];
        ob2 = new byte[_1M * 4];
        ob3 = new byte[_1M * 2];
        ob1 = null;
        ob4 = new byte[_1M * 6];
    }

    /**
     * JVM参数：-Xmn10m -Xmx20m -Xms20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */
    private static void testMinorGC(){
        byte[] ob1,ob2,ob3,ob4;
        ob1 = new byte[_1M * 2];
        ob2 = new byte[_1M * 2];
        ob3 = new byte[_1M * 2];
        ob4 = new byte[_1M * 4];
    }

    /**
     * 测试大对象直接进入到老年代分配内存空间
     * JVM参数：-Xmn10m -Xmx20m -Xms20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     *
     * -XX:PretenureSizeThreshold=3145728 被设置成了3M
     */
    private static void testPretenureSizeThreshold(){
        byte[] ob1= new byte[_1M * 6];
    }

    /**
     * 测试GC对象年龄
     * JVM参数：-Xmn10m -Xmx20m -Xms20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold = 1
     */
    private static void testMaxTenuringThreshold(){
        byte[] ob1,ob2,ob3,ob4;
        ob1= new byte[_1M /4];
        ob2= new byte[_1M * 4];
        ob3= new byte[_1M * 4];
//        ob3= null;
//        ob3= new byte[_1M * 4];
    }


}
