package com.open.newfeature.jdk9_12;

import org.junit.Test;

import java.util.stream.Collectors;

public class newFeature {

    @Test
    public void example1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //设置为只读list
        list = Collections.unmodifiableList(list);
        System.out.println(list);
        //执行add操作时会抛出java.lang.UnsupportedOperationException的异常
        list.add("d");

    }

    @Test
    public void example2() {
        List<String> list = List.of("a", "b", "c");
        System.out.println(list);
        Set<String> set = Set.of("a", "b", "c");
        System.out.println(set);
        Map<String, String> map = Map.of("k1", "a", "k2", "b");
        System.out.println(map);
    }

    @Test
    public void example3() {
        List<String> list1 = List.of("SpringBoot", "", "SpringCloud", "Redis").stream()
                .takeWhile(obj -> !obj.isEmpty()).collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 = List.of("SpringBoot", "", "SpringCloud", "Redis").stream()
                .dropWhile(obj -> !obj.isEmpty()).collect(Collectors.toList());
        System.out.println(list2);
     }

    @Test
    public void testVar() {
        var strVar = "SpringBoot";
        System.out.println(strVar instanceof String);//true

        //repeat(int count)方法:⽤于字符串循环输出
        System.out.println(strVar.repeat(2));

        var flagVar = Boolean.valueOf(true);
        System.out.println(flagVar instanceof Boolean);//true

        for (var i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    @Test
    public void testString() {
        " ".isBlank(); // true
        // 去除首尾空格
        " Javastack ".strip(); // "Javastack"
        // 去除尾部空格
        " Javastack ".stripTrailing();
        // 去除首部空格
        " Javastack ".stripLeading(); // "Javastack "
        // 复制字符串
        System.out.println("Java".repeat(3));// "JavaJavaJava"
        // 行数统计
        System.out.println("A\nB\nC".lines().count()); // 3
    }

}
