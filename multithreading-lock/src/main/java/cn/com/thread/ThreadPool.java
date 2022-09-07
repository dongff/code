package cn.com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-26 9:52
 * @modified By:
 */
public class ThreadPool {

    private static int POOL_NUM = 10;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < POOL_NUM; i++) {
            RunnableThread1 thread = new RunnableThread1();
            executorService.execute(thread);
        }
        //关闭线程池
        executorService.shutdown();

    }


}

class RunnableThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("我是线程4：" + Thread.currentThread().getName());
    }
}
