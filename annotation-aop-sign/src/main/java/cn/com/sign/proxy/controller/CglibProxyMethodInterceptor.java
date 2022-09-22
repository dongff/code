package cn.com.sign.proxy.controller;

import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 11:15
 * @modified By:
 */
public class CglibProxyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("我是总代理，我给大家介绍");
        Object object = proxy.invokeSuper(target, args);
        System.out.println("代理结束");
        return object;

    }
}
