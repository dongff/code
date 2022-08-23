package cm.com.designpattern;

/**
 * @author: dongff
 * @description: : 双重检验锁
 * @date: Created in 2022-08-23 10:36
 * @modified By:
 */
public class Singleton {
    // 添加 volatile 关键字 避免指令重排
    public volatile static Singleton singleton;

    public Singleton() {
    }

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
