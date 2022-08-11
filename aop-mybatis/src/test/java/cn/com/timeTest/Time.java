package cn.com.timeTest;


import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-10 16:15
 * @modified By:
 */

public class Time {

    @Test
    public void springTimeTest() throws InterruptedException {
        org.springframework.util.StopWatch stopWatch = new org.springframework.util.StopWatch();

        // 任务一模拟休眠3秒钟
        stopWatch.start("TaskOneName");
        Thread.sleep(1000 * 3);
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        stopWatch.stop();

        // 任务一模拟休眠10秒钟
        stopWatch.start("TaskTwoName");
        Thread.sleep(1000 * 10);

        stopWatch.stop();
        System.out.println("当前任务名称：" + stopWatch.getTotalTimeMillis());
        // 任务一模拟休眠10秒钟
        stopWatch.start("TaskThreeName");
        Thread.sleep(1000 * 10);
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        stopWatch.stop();

        // 打印出耗时
        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.shortSummary());
        // stop后它的值为null
        System.out.println(stopWatch.currentTaskName());

        // 最后一个任务的相关信息
        System.out.println(stopWatch.getLastTaskName());
        System.out.println(stopWatch.getLastTaskInfo());

        // 任务总的耗时  如果你想获取到每个任务详情（包括它的任务名、耗时等等）可使用
        System.out.println("所有任务总耗时：" + stopWatch.getTotalTimeMillis());
        System.out.println("任务总数：" + stopWatch.getTaskCount());
        System.out.println("所有任务详情：" + stopWatch.getTaskInfo());
    }


    @Test
    public  void apacheTimeTest() throws InterruptedException {
        //创建后立即start，常用
       // StopWatch watch = StopWatch.createStarted();

         StopWatch watch = new StopWatch();
         watch.start();

        Thread.sleep(1000);
        System.out.println(watch.getTime());
        System.out.println("统计从开始到现在运行时间：" + watch.getTime() + "ms");

        Thread.sleep(1000);
        watch.split();
        System.out.println("从start到此刻为止的时间：" + watch.getTime());
        System.out.println("从开始到第一个切入点运行时间：" + watch.getSplitTime());
        Thread.sleep(1000);
        watch.split();
        System.out.println("从开始到第二个切入点运行时间：" + watch.getSplitTime());

        // 复位后, 重新计时
        watch.reset();
        watch.start();
        Thread.sleep(1000);
        System.out.println("重新开始后到当前运行时间是：" + watch.getTime());

        // 暂停 与 恢复
        watch.suspend();
        System.out.println("暂停2秒钟");
        Thread.sleep(2000);

        // 上面suspend，这里要想重新统计，需要恢复一下
        watch.resume();
        System.out.println("恢复后执行的时间是：" + watch.getTime());

        Thread.sleep(1000);
        watch.stop();

        System.out.println("花费的时间》》" + watch.getTime() + "ms");

    }
}
