package com;

import java.util.Arrays;
import java.util.List;

/**
 * @author: dongff
 * @description: JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，
 * 使stream的每个元素都传入到该方法里面执行一下。
 *
 *  例1，
 * 表达式： person -> person.getAge();
 * 双冒号：Person :: getAge
 * 例2，
 * 表达式：new HashMap<>()
 * 双冒号：HashMap :: new
 *
 * @date: Created in 2022-09-21 10:08
 * @modified By:
 */
public class AcceptMethod {

    public static void  printValur(String str){
        System.out.println("print value : "+str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a","b","c","d");
        for (String a: al) {
            AcceptMethod.printValur(a);
        }
        System.out.println("------------");
        //下面的for each循环和上面的循环是等价的
        al.forEach(x->{
            AcceptMethod.printValur(x);
        });

        System.out.println("------------");
        al.forEach(AcceptMethod::printValur);
        System.out.println("------------");

        //下面的方法和上面等价的
        java.util.function.Consumer<String> methodParam = AcceptMethod::printValur; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept

    }
}
