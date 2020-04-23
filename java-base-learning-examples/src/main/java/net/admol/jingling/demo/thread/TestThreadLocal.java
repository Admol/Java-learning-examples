package net.admol.jingling.demo.thread;

/**
 * 线程副本
 * @author : jingling
 * @Date : 2018/1/3
 */
public class TestThreadLocal {

    // 共享变量
    private static ThreadLocal<Integer> numberLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getNumberLocal(){
        return numberLocal;
    }

    public int getNextNum(){
        numberLocal.set(numberLocal.get() + 1);
        return numberLocal.get();
    }

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        Thread thread1 = new TestThreadClient(testThreadLocal,"thread1");
        Thread thread2 = new TestThreadClient(testThreadLocal,"thread2");
        Thread thread3 = new TestThreadClient(testThreadLocal,"thread3");
        thread1.start();
        thread2.start();
        thread3.start();

    }


    private static class TestThreadClient extends Thread{

        private TestThreadLocal testThreadLocal;

        public TestThreadClient(TestThreadLocal testThreadLocal,String name) {
            this.testThreadLocal = testThreadLocal;
            super.setName(name);
        }

        @Override
        public void run() {
            for (int i=0 ;i < 3 ;i++){
                String name = Thread.currentThread().getName();
                System.out.println("线程名字:"+name +"  num : " +testThreadLocal.getNextNum() );
            }
            testThreadLocal.getNumberLocal().remove();
        }
    }
}
