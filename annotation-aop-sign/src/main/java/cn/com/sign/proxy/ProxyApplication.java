package cn.com.sign.proxy;

import cn.com.sign.proxy.controller.CglibProxyMethodInterceptor;
import cn.com.sign.proxy.controller.ThirdTestClassServiceImpl;
import org.assertj.core.internal.cglib.proxy.Enhancer;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 9:52
 * @modified By:
 */
public class ProxyApplication {
    //静态代理
    //public static void main(String[] args) {
    //    MainTestClassService target = new MainTestClassServiceImpl();
    //    MainTestClassProxy proxy = new MainTestClassProxy(target);
    //    proxy.HelloTest();
    //}

    //jdk动态代理
    //public static void main(String[] args) {
    //    MainTestClassService target = new MainTestClassServiceImpl();
    //    MainTestClassProxy proxy = new MainTestClassProxy(target);
    //    MainTestClassService serviceproxy = (MainTestClassService)proxy.getProxy();
    //    serviceproxy.HelloTest();
    //
    //    SecondTestClassService target2 = new SecondTestClassServiceImpl();
    //    MainTestClassProxy proxy2 = new MainTestClassProxy(target2);
    //    SecondTestClassService serviceproxy2 = (SecondTestClassService)proxy2.getProxy();
    //    serviceproxy2.HelloTest();
    //}


    //cglib动态代理
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ThirdTestClassServiceImpl.class);
        enhancer.setCallback(new CglibProxyMethodInterceptor());
        ThirdTestClassServiceImpl userService = (ThirdTestClassServiceImpl)enhancer.create();
        userService.HelloTest();
    }


}


