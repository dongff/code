package cn.com.designpattern;

/**
 * @author: dongff
 * @description: : 双重检验锁
 * @date: Created in 2022-08-23 10:36
 * @modified By:
 */
public class Singleton {

    public Singleton() {
    }

    //饿汉单例
    private static Singleton singleton2 = new Singleton();

    public static Singleton getSingleton2() {
        return singleton2;
    }


    /**
     * 双重检验懒汉单例
     */
    // 添加 volatile 关键字 避免指令重排
    public volatile static Singleton singleton;

    /**
     * 双重检验首先判断实例是否为空，
     * 然后使用 synchronized (Singleton.class) 使用类锁，锁住整个类，
     * 执行完代码块的代码之后，新建了实例，
     * 其他代码都不走 if (singleton == null) 里面，只会在最开始的时候效率变慢。
     * 而 synchronized 里面还需要判断是因为可能同时有多个线程都执行到 synchronized (Singleton.class) ，
     * 如果有一个线程线程新建实例，其他线程就能获取到 singleton 不为空，就不会再创建实例了。
     *
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
