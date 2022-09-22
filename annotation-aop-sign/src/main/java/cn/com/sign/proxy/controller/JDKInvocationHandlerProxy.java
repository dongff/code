package cn.com.sign.proxy.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 9:54
 * @modified By:
 */
//public class MainTestClassProxy{ //implements MainTestClassService {
//    private MainTestClassService target;
//
//    public MainTestClassProxy(MainTestClassService target) {
//        this.target = target;
//    }
//
//   // @Override
//    public void HelloTest() {
//        System.out.println("我是中介代理，小明说：");
//        target.HelloTest();
//        System.out.println("代理结束");
//    }
//}

/**
 * JDK代理
 */
public class JDKInvocationHandlerProxy implements InvocationHandler {
    private Object target;
    public JDKInvocationHandlerProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是总代理，我给大家介绍");
        Object object = method.invoke(target , args);
        System.out.println("代理结束");
        return object;
    }

    public Object getProxy(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader , interfaces , this::invoke);
    }
}
