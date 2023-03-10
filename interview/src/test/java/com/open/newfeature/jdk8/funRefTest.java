package com.open.newfeature.jdk8;

import org.junit.Test;

import java.util.function.Consumer;

public class funRefTest {

    @Test
    public void example1(){
        //使用Lambda表达式
        Consumer<String> consumer1 = x -> System.out.println(x);
        consumer1.accept("Lambda表达式");

        //使用方法引用
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("方法引用::");
    }

}
