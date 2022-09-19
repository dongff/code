- 单例模式
  Singleton： 使用关键字volatile+synchronized实现饿汉线程模式实现
  
-多线程
多线程的四种实现方式
1.继承Thread类，重写run方法 
    新建状态:使用 new 关键字和 Thread 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 start() 这个线程
    就绪状态:当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。
    运行状态:如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。
    阻塞状态:如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。
            在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：
         
           等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
           同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
           其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。
   死亡状态: 一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。
2.实现Runnable接口，重写run方法
3.通过Callable和ExecutorService创建线程
4.通过线程池创建线程

前面两种可以归结为一类：无返回值（通过重写run方法，run方式的返回值是void，所以没有办法返回结果）
后面两种可以归结成一类：有返回值，通过Callable接口，就要实现call方法，这个方法的返回值是Object，
所以返回的结果可以放在Object对象中

Executors类：提供了一系列工厂方法用于创建线程池，返回的线程池都实现了ExecutorService接口。

public static ExecutorService newFixedThreadPool(int nThreads)
创建固定数目线程的线程池。（创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。）
public static ExecutorService newCachedThreadPool()
创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
（创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。）

public static ExecutorService newSingleThreadExecutor()
创建一个单线程化的Executor。（ 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。）
public static ScheduledExecutorService newScheduledThreadPool(int
corePoolSize)
创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。（创建一个定长线程池，支持定时及周期性任务执行。）

ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。

二、Thread 和Runnable 的区别和联系
Thread其实本身就是实现了接口 Runnable的一个类;Thread类也是Runnable接口的子类。
因此 Thread中的方法和成员变量要比Runnable多，最典型地就是 Thread有start()方法，但是Runnable接口没有start()方法；

实际开发中我们通常采用Runnable接口来实现多线程。实现Runnable接口比继承Thread类有如下好处： 
1. 避免继承的局限，一个类可以继承多个接口，但是类只能继承一个类。 
2. Runnable接口实现的线程便于资源共享。而通过Thread类实现，各自线程的资源是独立的，不方便共享。 


-volatile
  volatile主要作用是保证可见性以及有序性。不负责解决原子性问题！
  也就是说，volatile主要解决的是一个线程修改变量值之后，其他线程立马可以读到最新的值，是解决这个问题的，也就是可见性！
  但是如果是多个线程同时修改一个变量的值，那还是可能出现多线程并发的安全问题，导致数据值修改错乱，volatile是不负责解决这个问题的，也就是不负责解决原子性问题！
  原子性问题，得依赖synchronized、ReentrantLock等加锁机制来解决。
  
synchronized和Lock的区别 总结
     synchronized是Java内置的一个关键字，Lock是是一个Java接口
     synchronized无法判断获取锁的状态，而lock锁可以判断是否获取到了锁
     synchronized回自动释放锁，而lock必须手动释放锁。如果不释放就会变成死锁
     synchronized 线程1（获得锁，阻塞）线程2（傻傻地等待），lock就不一定会等待
     synchronized 可重入锁，不可以中断的，非公平。lock锁 可重入锁，可以判断锁，公平不公平自己可以设置
     synchronized适合锁少量的代码同步问题 Lock适合锁大量的同步代码 
  
-synchronized
 Synchronized 是Java 并发编程中很重要的关键字，另外一个很重要的是 volatile。Syncronized 的目的是一次只允许一个线程进入由他修饰的代码段，从而允许他们进行自我保护。
 Synchronized 很像生活中的锁例子，进入由Synchronized 保护的代码区首先需要获取 Synchronized 这把锁，其他线程想要执行必须进行等待。Synchronized 锁住的代码区域执行完成后需要把锁归还，也就是释放锁，这样才能够让其他线程使用。
 它提供了⼀种独占的加锁⽅式。Synchronized的获取和释放锁由JVM实现，⽤户不需要显示的释放锁，⾮常⽅便。然⽽synchronized也有⼀定的局限性：
     当线程尝试获取锁的时候，如果获取不到锁会⼀直阻塞。属于是一种悲观锁。
     如果获取锁的线程进⼊休眠或者阻塞，除⾮当前线程异常，否则其他线程尝试获取锁必须⼀直等待。
 synchronized可以锁代码块、方法和对象。
     方法声明时使用，放在范围操作符之后,返回类型声明之前。即一次只能有一个线程进入该方法，其他线程要想在此时调用该方法，只能排队等候。当作用于静态方法时，锁住的是Class实例，又因为Class的相关数据存储在永久带PermGen（jdk1.8 则是 metaspace），永久带是全局共享的，因此静态方法锁相当于类的一个全局锁，会锁所有调用该方法的线程；
 
 private int number;
 public synchronized void numIncrease(){
   number++;
 }
 
     你也可以在某个代码块上使用 Synchronized 关键字，表示只能有一个线程进入某个代码段。
 public void numDecrease(Object num){
   synchronized (num){
     number++;
   }
 }
     synchronized后面括号里是一对象，锁住的是所有以该对象为锁的代码块，此时线程获得的是对象锁。
 public void test() {
   synchronized (this) {
     // ...
   }
 }


-lock
Lock 是 Java并发编程中很重要的一个(Lock interface)接口，它要比 synchronized 关键字更能直译"锁"的概念，
Lock需要手动加锁和手动解锁，一般通过 lock.lock() 方法来进行加锁， 通过 lock.unlock() 方法进行解锁。
Lock 还有更强大的功能，例如，它的 tryLock 方法可以非阻塞方式去拿锁。

Lock接⼝⽐同步⽅法和同步块提供了更具扩展性的锁操作。他们允许更灵活的结构，可以具有完全不同的性质，
并且可以⽀持多个相关类的条件对象。

它的优势有：
    可以使锁更公平
    可以使线程在等待锁的时候响应中断
    可以让线程尝试获取锁，并在⽆法获取锁的时候⽴即返回或者等待⼀段时间，不会造成死锁。
    可以在不同的范围，以不同的顺序获取和释放锁
    
与 Lock 关联密切的锁有 ReentrantLock 和 ReadWriteLock。
ReetrantLock 实现了Lock接口，它是一个可重入锁，内部定义了公平锁与非公平锁。
   可重⼊锁是指同⼀个线程可以多次获取同⼀把锁。ReentrantLock和synchronized都是可重⼊锁。
   可中断锁是指线程尝试获取锁的过程中，是否可以响应中断。synchronized是不可中断锁，⽽ReentrantLock则提供了中断功能。
   公平锁是指多个线程同时尝试获取同⼀把锁时，获取锁的顺序按照线程达到的顺序。
   ⾮公平锁则允许线程“插队”。synchronized是⾮公平锁，⽽ReentrantLock的默认实现是⾮公平锁，但是也可以设置为公平锁。
   ReentrantLock它是JDK 1.5之后提供的API层⾯的互斥锁，需要lock()和unlock()⽅法配合try/finally语句块来完成。
   等待可中断避免，出现死锁的情况（如果别的线程正持有锁，会等待参数给定的时间，在等待的过程中，如果获取了锁定，就返回true，如果等待超时，返回false）
   公平锁与⾮公平锁多个线程等待同⼀个锁时，必须按照申请锁的时间顺序获得锁，Synchronized锁⾮公平锁，
   ReentrantLock默认的构造函数是创建的⾮公平锁，可以通过参数true设为公平锁，但公平锁表现的性能不是很好。

ReadWriteLock 一个用来获取读锁，一个用来获取写锁。
也就是说将文件的读写操作分开，分成2个锁来分配给线程，从而使得多个线程可以同时进行读操作。
ReentrantReadWirteLock实现了ReadWirteLock接口，并未实现Lock接口。



- 异步Async
