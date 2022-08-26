package cm.com.thread;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-26 9:18
 * @modified By:
 */

public class RunnableThread implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"->我是线程2");
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new RunnableThread());
        t1.start();
    }

}
