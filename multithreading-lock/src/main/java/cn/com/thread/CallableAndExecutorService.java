package cn.com.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-26 9:24
 * @modified By:
 */
@SpringBootTest
public class CallableAndExecutorService {


    public static void main(String[] args) {
        Callable<Object> oneCallable = new Tickets<Object>();
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);

        Thread t = new Thread(oneTask);
        System.out.println("线程 " + Thread.currentThread().getName());

        t.start();
    }

    @Test
    public void main1() {
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(()->System.out.println(Thread.currentThread().getName()));

        singleThreadPool.shutdown();
    }


    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();
    ExecutorService singleThreadPool = new ThreadPoolExecutor(4, 4,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());



}

class Tickets<Object> implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "我是线程3");
        return null;
    }

}



