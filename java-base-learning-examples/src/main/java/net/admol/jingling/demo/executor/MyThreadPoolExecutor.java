package net.admol.jingling.demo.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义时间一个简单功能的线程池
 * 首页思考线程池是什么, 能用来干什么
 * 思路:
 * 池,存储用的,有大小之分
 * 线程,先来后到,需要排队
 * 池满了,不让排队怎么办,需要拒绝策略
 * 所以线程池的基本参数 coreSize,maxSize,queue,rejectedExecutionHandler 就有了
 * 线程池的基本工作流程:
 *  1.初始化线程池
 *  2.执行任务
 *  3.按照coreSize线程数执行任务
 *  4.任务数达到coreSize后进来的任务加入到队列
 *  5.如果队列满了, 按照maxSize线程数进行执行任务
 *  6.如果任务数达到maxSize,后进来的任务按照拒绝策略来执行
 * @author : admol
 * @Date : 2020/6/19
 */
@Slf4j
public class MyThreadPoolExecutor implements Executor{
    /**
     * 线程池的核心大小
     */
    private volatile int coreSize;
    /**
     * 线程池的最大值
     */
    private volatile int maxSize;
    /**
     * 排队的线程队列
     */
    private final BlockingQueue<Runnable> taskQueue;

    /**
     * 拒绝策略
     */
    private volatile MyRejectedHandler handler;

    /**
     * 线程池线程名称前缀
     */
    private String poolNamePrefix ;
    private static final String defaultPoolNamePrefix = "default-my-thread-pool-";

    /**
     * 运行中的线程数
     */
    private final AtomicInteger runningCount = new AtomicInteger(0);

    public MyThreadPoolExecutor(int coreSize,int maxSize,BlockingQueue<Runnable> taskQueue){
        this(coreSize,maxSize,taskQueue,defaultPoolNamePrefix);
    }

    /**
     * 构造方法
     * @param coreSize
     * @param maxSize
     * @param taskQueue
     * @param poolNamePrefix
     */
    public MyThreadPoolExecutor(int coreSize,int maxSize,BlockingQueue<Runnable> taskQueue,String poolNamePrefix){
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskQueue = taskQueue;
        this.poolNamePrefix = poolNamePrefix;
        this.handler = new MyRejectedHandler();
    }

    /**
     * 线程池执行任务的基本流程:
     *  1.按照coreSize线程数执行任务
     *  2.任务数达到coreSize后进来的任务加入到队列
     *  3.如果队列满了, 按照maxSize线程数进行执行任务
     *  4.如果任务数达到maxSize,后进来的任务按照拒绝策略来执行
     * @param command
     */
    @Override
    public void execute(Runnable command){
        if(command == null){
            throw new NullPointerException();
        }
        // 1.判断线程数是否达到了核心大小
        if(runningCount.get() < coreSize){
            // 1.1 没有达到coreSize, 按照核心线程执行
            if(addWorker(command,true)){
                return;
            }
        }
        // 2.加入到队列, 加入失败会返回false, 如果用add, 队列满会抛异常
        if(taskQueue.offer(command)){
        }else{
            // 3.加入队列失败, 以非核心线程的方式执行线程任务
            if(!addWorker(command,false)){
                // 3.1 以非核心线程的方式执行失败, 执行拒绝策略
                reject(command);
            }
        }
    }

    /**
     * 拒绝策略
     * @param command
     */
    private void reject(Runnable command){
        handler.rejectedExecution(command,this);
    }

    /**
     * 添加到工作线程
     * @param command
     * @param coreThread
     */
    private boolean addWorker(Runnable command,boolean coreThread){
        // 自旋
        for(;;){
            // 运行中的线程数
            int running = runningCount.get();
            // 确实是取核心大小还是最大值
            int wc = coreThread ? coreSize : maxSize;
            if(running >= wc){
                return false;
            }
            // 工作线程+1, 失败则自旋
            if(runningCount.compareAndSet(running,running+1)){
                break;
            }
        }
        // 标识是否开始工作
        boolean workerStarted = false;
        String coreThreadStr = coreThread ? "core-":"max-";
        String threadName = defaultPoolNamePrefix + coreThreadStr + runningCount.get();
        final Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                // 执行任务
                runWorker(command);
                // 执行完任务, runningCount-1
                runningCount.decrementAndGet();
            }
        },threadName);
        if (t != null) {
            t.start();
            workerStarted = true;
        }
        return workerStarted;
    }

    /**
     * 执行任务, 反复从队列取任务并执行
     * @param task
     */
    private void runWorker(Runnable task){
        Runnable t = task;
        while(t != null || (t = getTask()) != null){
            try{
                log.info(Thread.currentThread().getName()+" is running");
                t.run();
            }catch(Exception e){
                throw e;
            }finally{
                t = null;
            }
        }
    }

    /**
     * 从队列获取任务, 可以加入超时机制
     * @return
     */
    private Runnable getTask(){
        try{
            return taskQueue.take();
        }catch(InterruptedException e){
            return null;
        }
    }

    class MyRejectedHandler {
        public void rejectedExecution(Runnable r,MyThreadPoolExecutor executor){
            log.info(r.toString()+": 执行了拒绝策略");
            // 可以自定拒绝策略, 执行, 忽略, 从队列取任务, 抛异常都可以
            //r.run();
        }
    }
}
