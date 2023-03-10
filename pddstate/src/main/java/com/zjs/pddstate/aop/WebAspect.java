package com.zjs.pddstate.aop;

import com.zjs.pddstate.model.pdd.PddRequest;
import com.zjs.pddstate.util.SignUtil;
import com.zjs.pddstate.util.WebErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

import static com.zjs.pddstate.util.Util.objMapper;

@Slf4j
@Component
@Aspect
public class WebAspect {

//
//    /**
//     * 切入点
//     * 匹配com.example.controller1包及其子包下的所有类的所有方法
//     */
//
//    @Pointcut("execution(* com.zjs.pddstate.web..*.*(..))")
//    public void executePackage(){
//    }
//
//
//    /**
//     * 前置通知，目标方法调用前被调用
//     * @param joinPoint
//     */
//
//    @Before("executePackage()")
//    public void beforeAdvice(JoinPoint joinPoint){
//        System.out.println("- - - - - 前置通知 - - - - -");
//        Signature signature = joinPoint.getSignature();
//        System.out.println("返回目标方法的签名："+signature);
//        System.out.println("代理的是哪一个方法："+signature.getName());
//        Object[] obj = joinPoint.getArgs();
//        System.out.println("获取目标方法的参数信息："+Arrays.asList(obj));
//    }
//
//
//    /**
//     * 后置最终通知，目标方法执行完执行
//     */
//
//    @After("executePackage()")
//    public void afterAdvice(){
//        System.out.println("- - - - - 后置最终通知- - - - -");
//    }
//
//    /**
//     * 后置返回通知
//     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
//     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
//     * returning 只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行
//     * @param joinPoint
//     * @param keys
//     */
//
//    @AfterReturning(value = "execution(* com.zjs.pddstate.web..*.*(..))",returning = "keys")
//    public void afterReturningAdvice(JoinPoint joinPoint,String keys){
//        System.out.println("- - - - - 后置返回通知- - - - -");
//        System.out.println("后置返回通知 返回值："+keys);
//    }
//
//
//
//    /**
//     * 后置异常通知
//     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
//     *  throwing 只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
//     * @param joinPoint
//     * @param exception
//     */
//
//    @AfterThrowing(value = "executePackage()",throwing = "exception")
//    public void afterThrowingAdvice(JoinPoint joinPoint,NullPointerException exception){
//        System.out.println("- - - - - 后置异常通知 - - - - -");
//    }

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    SignUtil signUtil;

    /**
     * 切入点
     * 匹配com.example.controller1包及其子包下的所有类的所有方法
     */
    @Pointcut("@annotation(WebAop)")
    public void webAops(){
    }

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Order(1)
    @Around(value = "webAops()&&@annotation(webAop)")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint,WebAop webAop){
        String uuid = UUID.randomUUID().toString().replace("-", "");
         try {
            //请求中打入uuid
            httpServletRequest.setAttribute("uuid",uuid);

            Object[] args = proceedingJoinPoint.getArgs();
            log.info(uuid + " {}请求参数为:{}" ,webAop.value(),objMapper.writeValueAsString(args));
            //加密验证
             PddRequest<String> pddRequest = (PddRequest<String>) args[0];
             Object result;
             if(signUtil.sign(uuid,pddRequest)){
                 //动态修改其参数
                 //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
                 result = proceedingJoinPoint.proceed(args);
             }else {
                 result = WebErrorUtil.getString(pddRequest.getShip_id(),false,"1101");
             }
             log.info(uuid + " {}响应结果为:{}" ,webAop.value(),objMapper.writeValueAsString(result));
            //如果这里不返回result，则目标对象实际返回值会被置为null
            return result;
        } catch (Throwable throwable) {
             log.error(uuid+" AOP异常！",throwable);
         }
        return "AOP异常";
    }
}
