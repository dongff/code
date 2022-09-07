package cn.com.thread;

import lombok.NoArgsConstructor;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-26 8:47
 * @modified By:
 */
@SpringBootTest
@NoArgsConstructor
public class CreatThread extends Thread {

    @Override
    public void run() {

        float a=5151;

        for (int i = 0; i < 100000; i++) {
            //dosomething
            a=5151*432/344+8797-7987;
        }

        System.out.println("run " + Thread.currentThread().getName());
    }

    @Test
    public  void testCreatThread() {

        StopWatch watch = new StopWatch();
        watch.start();

        CreatThread test1 = new CreatThread();
        test1.setName("我是线程1");
        test1.start();
        watch.split();
        System.out.println( "从开始到第一个切入点运行时间：" + watch.getSplitTime()+ "我是线程11" + Thread.currentThread().toString());

        CreatThread test2 = new CreatThread();
        test2.setName("我是线程2");
        test2.start();
        watch.split();
        System.out.println("从开始到第二个切入点运行时间：" + watch.getSplitTime()+"我是线程22" + Thread.currentThread().toString());

        Thread test3=new Thread();
        test3.setName("我是线程3");
        test3.start();
        watch.split();
        System.out.println("从开始到第3个切入点运行时间：" + watch.getSplitTime()+"我是线程33" + Thread.currentThread().toString());


    }


}
