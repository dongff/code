package cn.com.thread.threadpool;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-26 10:27
 * @modified By:
 */
@SpringBootTest
public class ExecutorDemo {
    /**
     * 因为我们用不到队列来存任务，所以我这用了 size为1 的数组队列,静态的保证不会生成太多次对象
     */
    private final static ArrayBlockingQueue QUEUE = new ArrayBlockingQueue(1);

    @Test
    public  void aa() throws  java.lang.InterruptedException,java.util.concurrent.ExecutionException{
        //引入自己定义的线程池类
        ExecutorService poolExecutor = new MyThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, QUEUE);
       // ExecutorService poolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, QUEUE);

        //log.info("监控queue 队列是否为空，{}"+QUEUE.isEmpty());

        String waybillCode ="1";
        String pickerUsercode ="1";

        FutureTask<String> futureTask1 = new FutureTask<>(() -> method1(waybillCode));
        FutureTask<String> futureTask2 = new FutureTask<>(() -> method2(waybillCode));
        FutureTask<String> futureTask3 = new FutureTask<>(() -> method3(waybillCode));
        FutureTask<String> futureTask4 = new FutureTask<>(() -> method4(pickerUsercode));
        FutureTask<String> futureTask5 = new FutureTask<>(() -> method5(waybillCode));


        poolExecutor.submit(futureTask1);
        poolExecutor.submit(futureTask2);
        poolExecutor.submit(futureTask3);
        poolExecutor.submit(futureTask4);
        poolExecutor.submit(futureTask5);

        String aladinWayBillDtoList = futureTask1.get();
        String sensMessage = futureTask2.get();
        String recvaInfo = futureTask3.get();
        String employeeInfoBodyList = futureTask4.get();
        String addressResolves = futureTask5.get();

        System.out.println(aladinWayBillDtoList);
        System.out.println(sensMessage);
        System.out.println(recvaInfo);
        System.out.println(employeeInfoBodyList);
        System.out.println(addressResolves);
        //关闭线程池
        poolExecutor.shutdown();

       //do some thing
        // return ConvertToCommonReqDtoUtil.convert(quPaiData, aladinWayBillDtoList, employeeInfoBodyList, sensMessage, recvaInfo, addressResolves, customerModel);

    }
    private String method1(String paramter){
        return "method1";
    }
    private String method2(String paramter){
        return "method2";
    }
    private String method3(String paramter){
        return "method3";
    }
    private String method4(String paramter){
        return "method4";
    }
    private String method5(String paramter){
        return "method5";
    }

}
