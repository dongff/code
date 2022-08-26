- 单例模式
  Singleton： 使用关键字volatile+synchronized实现饿汉线程模式实现
  
-多线程
多线程的四种实现方式
陈皮话梅糖。
于 2021-09-23 15:23:37 发布 492
收藏
文章标签： java 多线程
版权

1.继承Thread类，重写run方法
2.实现Runnable接口，重写run方法
3.通过Callable和ExecutorService创建线程
4.通过线程池创建线程

前面两种可以归结为一类：无返回值（通过重写run方法，run方式的返回值是void，所以没有办法返回结果）
后面两种可以归结成一类：有返回值，通过Callable接口，就要实现call方法，这个方法的返回值是Object，
所以返回的结果可以放在Object对象中


Executors类：提供了一系列工厂方法用于创建线程池，返回的线程池都实现了ExecutorService接口。

public static ExecutorService newFixedThreadPool(int nThreads)
创建固定数目线程的线程池。
public static ExecutorService newCachedThreadPool()
创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
public static ExecutorService newSingleThreadExecutor()
创建一个单线程化的Executor。
public static ScheduledExecutorService newScheduledThreadPool(int
corePoolSize)
创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。
二、Thread 和Runnable 的区别和联系

Thread其实本身就是实现了接口 Runnable的一个类;Thread类也是Runnable接口的子类。
因此 Thread中的方法和成员变量要比Runnable多，最典型地就是 Thread有start()方法，但是Runnable接口没有start()方法；

实际开发中我们通常采用Runnable接口来实现多线程。实现Runnable接口比继承Thread类有如下好处： 
1. 避免继承的局限，一个类可以继承多个接口，但是类只能继承一个类。 
2. Runnable接口实现的线程便于资源共享。而通过Thread类实现，各自线程的资源是独立的，不方便共享。 
