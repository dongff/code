package cm.com.thread.threadpool;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yjc
 * 自定义线程池，主要为了 子线程能获取到 父线程里面的 threadLocal 变量
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {


    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public Future<?>  submit( Runnable task) {
        Map<String, String> map = MDC.getCopyOfContextMap();
        return super.submit(()->{
            MDC.setContextMap(map);
        try {
             task.run();
        } finally {
            try {
                MDC.clear();
            } catch (Exception e2) {
                System.out.println(("子线程madc 清空异常警告"));
            }
        }
        });
    }



}
