package cn.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-18 14:42
 * @modified By:
 */
//该注解表示这是个切面
@Aspect
//将该对象交给Spring 的Ico容器管理
@Component
public class AopAspect {
    /**
     * 定义一个切入点表达式,用来确定哪些类需要代理
     * execution(* aopdemo.*.*(..))代表aopdemo包下所有类的所有方法都会被代理
     * /**
     * 连接点 将CarService接口的所有实现类中的方法作为接入点，绑定到carRun（）上。
     * execution 中字符发解释
     * 1.第一个 * 任意返回值
     * 2.中间的是包名
     * 3.第二个*表示server包下的所有对象
     * 4.括号表示接收参数
     * 5.括号中的..表示任意参数
     * <p>
     * execution 绑定这一个
     * 还有 ：execution  within  this  target  args  @target  @args   @within  @annotation
     */
    @Pointcut("execution( * cn.com.aop.TargetClass.*(..))")
    public void declareJoinPointerExpression() {
    }

    /**
     * 前置方法,在目标方法执行前执行
     *
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
   @Before("declareJoinPointerExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(" " );
        System.out.println("Before----------------------------" );
        System.out.println("Before目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("Before目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("Before目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("Before目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
       System.out.println(Arrays.toString(joinPoint.getArgs()));


        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("Before第" + (i + 1) + "个参数为:" + args[i]);
        }
        System.out.println("Before被代理的对象:" + joinPoint.getTarget());
        System.out.println("Before代理对象自己:" + joinPoint.getThis());
        System.out.println("Before----------------------------" );
        System.out.println(" " );
    }

    /**
     * 环绕方法,可自定义目标方法执行的时机
     *
     * @param pjd JoinPoint的子接口,添加了
     *            Object proceed() throws Throwable 执行目标方法
     *            Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     *            两个方法
     * @return 此方法需要返回值, 返回值视为目标方法的返回值
     */
    @Around("declareJoinPointerExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;

        try {
            //前置通知
            System.out.println("Around目标方法执行前...");
            //执行目标方法
            result = pjd.proceed();
            System.out.println("Around目标方法返回..."+result);
            //用新的参数值执行目标方法
            result = pjd.proceed(new Object[]{"newSpring", "newAop"});
            //返回通知
            System.out.println("Around目标方法返回结果后..."+result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("Around执行目标方法异常后...");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("Around目标方法执行后...");

        return result;
    }

    @After("declareJoinPointerExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println(" " );
        System.out.println("After----------------------------" );
        System.out.println("After目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("After目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("After目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("After目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("After第" + (i + 1) + "个参数为:" + args[i]);
        }
        System.out.println("After被代理的对象:" + joinPoint.getTarget());
        System.out.println("After代理对象自己:" + joinPoint.getThis());
        System.out.println("After----------------------------" );
        System.out.println(" " );
    }
}
