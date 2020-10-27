package net.admol.jingling.demo.lock;

import sun.misc.Unsafe;


/**
 * 测试观察 synchronized 锁不同位置时字节码的区别
 * @author : admol
 * @Date : 2020/10/8
 */
public class SynchronizedTest2{
    public static void main(String[] args){
        Unsafe unsafe = Unsafe.getUnsafe();

        System.out.println(1);
    }
    /**
     *  public synchronized void method1();
     *     descriptor: ()V
     *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: iconst_1
     *          4: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *          7: return
     *       LineNumberTable:
     *         line 14: 0
     *         line 15: 7
     */
    public synchronized void method1(){
        System.out.println(1);
    }

    /**
     *   public static synchronized void method2();
     *     descriptor: ()V
     *     flags: (0x0029) ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=0, args_size=0
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: iconst_1
     *          4: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *          7: return
     *       LineNumberTable:
     *         line 29: 0
     *         line 30: 7
     */
    public synchronized static void method2(){
        System.out.println(2);
    }

    /**
     *  public void method3();
     *     descriptor: ()V
     *     flags: (0x0001) ACC_PUBLIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: aload_0
     *          1: dup
     *          2: astore_1
     *          3: monitorenter
     *          4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          7: iconst_3
     *          8: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *         11: aload_1
     *         12: monitorexit
     *         13: goto          21
     *         16: astore_2
     *         17: aload_1
     *         18: monitorexit
     *         19: aload_2
     *         20: athrow
     *         21: return
     *       Exception table:
     *          from    to  target type
     *              4    13    16   any
     *             16    19    16   any
     *       LineNumberTable:
     *         line 51: 0
     *         line 52: 4
     *         line 53: 11
     *         line 54: 21
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255 /* full_frame *\/
     *           offset_delta = 16
     *           locals = [ class net/admol/jingling/demo/lock/SynchronizedTest2, class java/lang/Object ]
     *           stack = [ class java/lang/Throwable ]
     *         frame_type = 250 /* chop *\/
     *           offset_delta = 4
     */
    public void method3(){
        synchronized(this){
            System.out.println(3);
        }
    }

    /**
     *  public void method4();
     *     descriptor: ()V
     *     flags: (0x0001) ACC_PUBLIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: ldc           #4                  // class net/admol/jingling/demo/lock/SynchronizedTest2
     *          2: dup
     *          3: astore_1
     *          4: monitorenter
     *          5: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          8: iconst_4
     *          9: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *         12: aload_1
     *         13: monitorexit
     *         14: goto          22
     *         17: astore_2
     *         18: aload_1
     *         19: monitorexit
     *         20: aload_2
     *         21: athrow
     *         22: return
     *       Exception table:
     *          from    to  target type
     *              5    14    17   any
     *             17    20    17   any
     *       LineNumberTable:
     *         line 92: 0
     *         line 93: 5
     *         line 94: 12
     *         line 95: 22
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255 /* full_frame *\/
     *           offset_delta = 17
     *           locals = [ class net/admol/jingling/demo/lock/SynchronizedTest2, class java/lang/Object ]
     *           stack = [ class java/lang/Throwable ]
     *         frame_type = 250 /* chop *\/
     *           offset_delta = 4
     */
    public void method4(){
        synchronized(SynchronizedTest2.class){
            System.out.println(4);
        }
    }

    /**
     *  public void method5();
     *     descriptor: ()V
     *     flags: (0x0001) ACC_PUBLIC
     *     Code:
     *       stack=2, locals=4, args_size=1
     *          0: new           #5                  // class java/lang/Object
     *          3: dup
     *          4: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          7: astore_1
     *          8: aload_1
     *          9: dup
     *         10: astore_2
     *         11: monitorenter
     *         12: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         15: iconst_5
     *         16: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *         19: aload_2
     *         20: monitorexit
     *         21: goto          29
     *         24: astore_3
     *         25: aload_2
     *         26: monitorexit
     *         27: aload_3
     *         28: athrow
     *         29: return
     *       Exception table:
     *          from    to  target type
     *             12    21    24   any
     *             24    27    24   any
     *       LineNumberTable:
     *         line 141: 0
     *         line 142: 8
     *         line 143: 12
     *         line 144: 19
     *         line 145: 29
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255 /* full_frame *\/
     *           offset_delta = 24
     *           locals = [ class net/admol/jingling/demo/lock/SynchronizedTest2, class java/lang/Object, class java/lang/Object ]
     *           stack = [ class java/lang/Throwable ]
     *         frame_type = 250 /* chop *\/
     *           offset_delta = 4
     */
    public void method5(){
        Object lock = new Object();
        synchronized(lock){
            System.out.println(5);
        }
    }
}
