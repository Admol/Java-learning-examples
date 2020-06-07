package net.admol.jingling.demo.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author : admol
 * @Date : 2020/5/5
 */
public class SynchronizedTest{

//    public static void main(String[] args){
//        LockClass lock = new LockClass();
//        // 没有加Synchronized时
//        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
//        /*
//        net.admol.jingling.demo.lock.SynchronizedTest$LockClass object internals:
//         OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//              0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//              4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//              8     4        (object header)                           43 c1 00 20 (01000011 11000001 00000000 00100000) (536920387)
//             12     4        (loss due to the next object alignment)
//        Instance size: 16 bytes
//        Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
//        */
//    }
    public static void main(String[] args){
        LockClass lock = new LockClass();
        // 加Synchronized时
        synchronized(lock){
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
        /*
        net.admol.jingling.demo.lock.SynchronizedTest$LockClass object internals:
         OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
              0     4        (object header)                           38 f1 68 02 (00111000 11110001 01101000 00000010) (40431928)
              4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
              8     4        (object header)                           43 c1 00 20 (01000011 11000001 00000000 00100000) (536920387)
             12     4        (loss due to the next object alignment)
        Instance size: 16 bytes
        Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
        */
    }

    public static class LockClass{}
}
