package com.open.newfeature.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class streamTest {

    @Test
    public void example1(){
        final List<String> stringList = Arrays.asList("Tom","Jack","Alice","Lina","Pony");

        //串行流
        long count1 = stringList.stream()
                .filter(s -> {
                    System.out.println(Thread.currentThread().getId() + "==" + Thread.currentThread().getName());
                    return s.length() > 3;
                })
                .count();
        System.out.println(count1);

        //并行流
        long count2 = stringList.parallelStream()
                .filter(s -> {
                    System.out.println(Thread.currentThread().getId() + "==" + Thread.currentThread().getName());
                    return s.length() > 3;
                })
                .count();
        System.out.println(count2);
    }
}
