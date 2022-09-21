package com;

import java.util.Random;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-20 17:35
 * @modified By:
 */
public class TestStaticFinal {

    public static void main(String[] args) {

        String str = "Hello Java. Java is a language.";
        System.out.println(str.replace("Java.", "c++"));//打印 Hello c++ Java is a language.
        System.out.println(str.replaceAll("Java.", "c++"));//打印 Hello c++ c++is a language.

        StaticFinal sf1 = new StaticFinal();
        StaticFinal sf2 = new StaticFinal();

        System.out.println(sf2.sValue);
        System.out.println(sf1.sValue);

        sf2.sValue =5;
        sf1.sValue=2;

        System.out.println(sf1.fValue == sf2.fValue);//打印false
        System.out.println(sf1.sValue == sf2.sValue);//打印true

        System.out.println(sf2.sValue);
        System.out.println(sf1.sValue);


    }
}

class StaticFinal {

    final int fValue = new Random().nextInt();
    static int sValue = new Random().nextInt();



}