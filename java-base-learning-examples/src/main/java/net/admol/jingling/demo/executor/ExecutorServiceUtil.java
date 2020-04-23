package net.admol.jingling.demo.executor;

import java.util.concurrent.*;

/**
 * @author : jingling
 * @Date : 2018/1/8
 */
public class ExecutorServiceUtil {

    private static class ExecutorServiceBuild{
        private static final  ExecutorService executorService = new ThreadPoolExecutor(10,15,10,
                TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(50),Executors.defaultThreadFactory());
    }
    private ExecutorServiceUtil() {
    }
    public static ExecutorService getExecutorService(){
        return ExecutorServiceBuild.executorService;
    }
}
