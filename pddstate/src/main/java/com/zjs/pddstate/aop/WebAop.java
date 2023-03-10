package com.zjs.pddstate.aop;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @Author: Lic
 * @create: 2020/8/21 14:10
 */
//什么时候使用该注解，我们定义为运行时
//注解的生命周期，表示注解会被保留到什么阶段，可以选择编译阶段、类加载阶段，或运行阶段
@Retention(RetentionPolicy.RUNTIME)
//注解作用的位置，ElementType.METHOD表示该注解仅能作用于方法上
@Target({ElementType.METHOD})
//注解是否将包含在 Java文档中
@Documented
//注解名为 WebAop;
public @interface WebAop {
    //定义一个属性，默认为空字符串；
    String value() default "";
}
