-Java中创建对象的5种方式 
   用 new 语句创建对象
   运用反射，调用 java.lang.Class 或 java.lang.reflect.Constructor 类的 newInstance() 方法
   调用对象的 clone() 方法
   运用反序列化手段，调用 java.io.ObjectInputStream 对象的 readObject() 方法
   上述 1、2 会调用构造函数
   上述 3、4 不会调用构造函数
   
-反射
   反射主要实现类有哪些？
   参考答案
   
   在JDK中，主要由以下类来实现 Java 反射机制，除了 Class 类，一般位于 java.lang.reflect 包中
   
       java.lang.Class ：一个类
       java.lang.reflect.Field ：类的成员变量(属性)
       java.lang.reflect.Method ：类的成员方法
       java.lang.reflect.Constructor ：类的构造方法
       java.lang.reflect.Array ：提供了静态方法动态创建数组，访问数组的元素

   
- 静态代理与动态代理proxy  

  
       两种动态代理方法:
               一、jdk继承InvocationHandler接口、 Proxy(Class)代理类（必须有方法） 
               二、Cglib库继承MethodInterceptor接口

- 技术栈
    统一返回使用泛型<T> ResponseResult类
 - lombok的@Builder建造者模式
   枚举设置返回 ResponseStatus类，具体实现见aop-mybatis
 
 - 切面编程 @Aspect
   @Component
   SignAspect 类，设置切点位置，使用@Before@Afer@Around
 
 - Signature注解 SignAspect切面编程实现注解
 
 
 Aop 在 Spring 中的作用
 提供声明式事务；允许用户自定义切面
 横切关注点：跨越应用程序多个模块的方法或功能。即是，与我们业务逻辑无关的，但是我们需要
 关注的部分，就是横切关注点。如日志 , 安全 , 缓存 , 事务等等 ....
 切面（ ASPECT ）：横切关注点 被模块化 的特殊对象。即，它是一个类。
 通知（ Advice ）：切面必须要完成的工作。即，它是类中的一个方法。
 目标（
 Target ）：被通知对象。
 代理（ Proxy ）：向目标对象应用通知之后创建的对象。
 切入点（ PointCut ）：切面通知 执行的 “ 地点 ” 的定义。
 连接点（ JointPoint ）：与切入点匹配的执行点。
 SpringAOP 中，通过 Advice 定义横切逻辑， Spring 中支持 5 种类型的 Advice:
 
 
 